package com.cookie312.test;

import com.cookie312.JPAUtils.JPAUtils;
import com.cookie312.domain.Customer;
import com.cookie312.domain.LinkMan;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class OneToMany {


	@Test
	public void test1 (){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		//向两张表中添加数据
		Customer c = new Customer();
		c.setCustName("可乐公司");

		LinkMan lkm = new LinkMan();
		lkm.setLkmName("小明");
		//添加关联关系
		c.getLinkmans().add(lkm);
		lkm.setCustomer(c);
		//保存数据 先保存主表,再保存从表
		entityManager.persist(c);
		entityManager.persist(lkm);

		transaction.commit();
		entityManager.close();
	}

	@Test
	public void test2 (){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		//查询主表时默认使用延时加载
		Customer customer = entityManager.find(Customer.class, 1L);
		System.out.println(customer);
		for (LinkMan linkMan : customer.getLinkmans()) {
			System.out.println(linkMan);
		}

		//查询从表时默认使用了立即加载
//		LinkMan linkMan = entityManager.find(LinkMan.class, 1L);
//		System.out.println(linkMan);
//		System.out.println(linkMan.getCustomer());
		transaction.commit();
		entityManager.close();
	}
}
