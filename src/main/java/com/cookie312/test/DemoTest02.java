package com.cookie312.test;


import com.cookie312.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DemoTest02 {

	@Test
	public void test (){
		//创建管理工厂(相当于连接池) 该方法会自动读取META-INF文件下的persistence文件固定的
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPAUnit");
		//创建操作数据的对象(相当于获取一个连接)
		EntityManager entityManager = factory.createEntityManager();
		//得到事务对象
		EntityTransaction transaction = entityManager.getTransaction();
		//开启事物
		transaction.begin();

//		Customer customer = entityManager.find(Customer.class, "8a7e852264d6d9910164d6d993ff0000");
		Customer customer = new Customer();
		customer.setCustName("你说呢明知你不在还是会问");
		entityManager.persist(customer);

		//提交事务
		transaction.commit();
		//关闭资源
		entityManager.close();
	}
}
