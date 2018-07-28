package com.cookie312.test;

import com.cookie312.JPAUtils.JPAUtils;
import com.cookie312.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class Select_Test {

	/**
	 * 查找所有
	 */
	@Test
	public void testFindAll(){
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();    //查询可以不用事务
		//创建查询条件 (编写JPQL语句)
		Query query = em.createQuery("from Customer");
		//执行查询
		List list = query.getResultList();
		for (Object o : list) {
			System.out.println(o);
		}
		transaction.commit();
		em.close();
	}

	/**
	 * 根据id查询一个对象
	 */
	@Test
	public void testFindById(){
		EntityManager entityManager = JPAUtils.getEntityManager();
//		Customer customer = entityManager.find(Customer.class, 8L);   //立即加载

		Customer customer = entityManager.getReference(Customer.class, 7L);   //延时加载使用时查询

		System.out.println(customer);
		entityManager.close();
	}

	/**
	 * 修改操作，先查询后修改
	 */
	@Test
	public void update (){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		//修改之前先根据id查找
		Customer customer = entityManager.find(Customer.class, 4L);
		customer.setCustName("空气2");     //修改之后并没有执行更新操作,数据也进行了更改

		entityManager.merge(customer);   //不添加这一句话也能执行操作

		transaction.commit();
		entityManager.close();
	}

	/***
	 * 删除一条数据,也是先查找后删除
	 */
	@Test
	public  void TestDelete(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Customer customer = entityManager.find(Customer.class, 8L);
		entityManager.remove(customer);
		transaction.commit();
		entityManager.close();

	}

}
