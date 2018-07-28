package com.cookie312.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_user")
@Getter
@Setter
public class SysUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	private String userName;

	//配置多对多关联关系  mappedBy放弃维护权
	@ManyToMany(targetEntity = SysRole.class,mappedBy = "sysUsers",cascade = CascadeType.ALL)
	private Set<SysRole> sysRole = new HashSet<SysRole>(0);



}
