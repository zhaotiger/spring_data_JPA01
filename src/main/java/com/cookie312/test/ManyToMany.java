package com.cookie312.test;

import com.cookie312.JPAUtils.JPAUtils;
import com.cookie312.domain.SysRole;
import com.cookie312.domain.SysUser;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ManyToMany {

	@Test
	public void test1() {
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		//创建2个用户和3个角色
		SysUser u1 = new SysUser();
		u1.setUserName("用户1");
		SysUser u2 = new SysUser();
		u2.setUserName("用户2");

		SysRole r1 = new SysRole();
		r1.setRoleName("角色1");
		SysRole r2 = new SysRole();
		r2.setRoleName("角色2");
		SysRole r3 = new SysRole();
		r3.setRoleName("角色3");
		//具有维护权限的类进行关联
		r1.getSysUsers().add(u1);
		r2.getSysUsers().add(u2);
		r2.getSysUsers().add(u1);
		r3.getSysUsers().add(u2);
		//保存数据  先保存主表数据再保存从表数据
		entityManager.persist(u1);
		entityManager.persist(u2);
		entityManager.persist(r1);
		entityManager.persist(r2);
		entityManager.persist(r3);

		transaction.commit();
		entityManager.close();

	}


	@Test
	public void remove(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
//		SysUser sysUser = entityManager.find(SysUser.class, 2L);
//		entityManager.remove(sysUser);
		SysRole sysRole = entityManager.find(SysRole.class, 2L);
		entityManager.remove(sysRole);

		transaction.commit();
		entityManager.close();

	}
}
