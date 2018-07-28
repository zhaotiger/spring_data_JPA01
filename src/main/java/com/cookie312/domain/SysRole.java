package com.cookie312.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="sys_role")
@Getter
@Setter
public class SysRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;

	@ManyToMany
	@JoinTable(name = "sys_user_role",  //中间表名称
			joinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")},    //设置当前表与中间表的对应
			inverseJoinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")}  //设置对应的user表与中间表的关系
	)
	private Set<SysUser> sysUsers = new HashSet<SysUser>();
}
