package com.cookie312.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 获取操作对象的工具类
 */
public class JPAUtils {

	//JPA的实体管理工厂(相当于连接池)
	private static EntityManagerFactory factory;

	static{
		//读取配置文件获取配置文件
		factory = Persistence.createEntityManagerFactory("myJPAUnit");
	}

	//得到操作数据的对象
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
