package com.cookie312.test;

import com.cookie312.JPAUtils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class SelectTest2 {

	/**
	 * 按条件查询
	 */
	@Test
	public void selectQuery(){
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();    //查询可以不用事务
		//创建查询条件 (编写JPQL语句)
//		Query query = em.createQuery("from Customer");  //查询所有
		Query query = em.createQuery("from Customer where custName = ?");  //按条件查询  用? 占位符

		query.setParameter(1, "修正药业");
		//执行查询
		List list = query.getResultList();
		for (Object o : list) {
			System.out.println(o);
		}
		transaction.commit();
		em.close();
	}

	/**
	 * 排序查询
	 */
	@Test
	public void orderQuery(){
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();    //查询可以不用事务
		// 操作的对象查询, 表名是类名, 列名是属性名
		Query query = em.createQuery("from Customer order by custId desc");
		List resultList = query.getResultList();
		for (Object o : resultList) {
			System.out.println(o);
		}

		transaction.commit();
		em.close();
	}


	/**
	 * 分页查询
	 */
	@Test
	public void pageQuery(){
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();    //查询可以不用事务
		Query query = em.createQuery("from Customer");//条件设置查询所有
		query.setFirstResult(2);   //从哪条开始查
		query.setMaxResults(2);    //每次查询的条数    //在执行查询前设置两个属性
		List resultList = query.getResultList();
		for (Object o : resultList) {
			System.out.println(o);
		}

		transaction.commit();
		em.close();
	}
}
