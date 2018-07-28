package com.cookie312.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "cst_customer")
@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")    //指定和表中 cust_id字段的映射关系
	private Long custId;

	@Column(name="cust_name")
	private String custName;

	@Column(name="cust_source")
	private String custSource;

	@Column(name="cust_industry")
	private String custIndustry;

	@Column(name="cust_level")
	private String custLevel;

	@Column(name="cust_address")
	private String custAddress;

	@Column(name="cust_phone")
	private String custPhone;
	//配置一对多的关系
	//targetEntity 一对多对应的类
	//mappedBy 放弃维护权利, 外键由从表维护. 值与从表的对应的字段对应
	//fetch  选则使用延时加载还是立即加载
	@OneToMany(targetEntity = LinkMan.class,mappedBy = "customer",fetch=FetchType.EAGER)
	private Set<LinkMan> linkmans = new HashSet<LinkMan>();

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public Set<LinkMan> getLinkmans() {
		return linkmans;
	}

	public void setLinkmans(Set<LinkMan> linkmans) {
		this.linkmans = linkmans;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"custId=" + custId +
				", custName='" + custName + '\'' +
				", custSource='" + custSource + '\'' +
				", custIndustry='" + custIndustry + '\'' +
				", custLevel='" + custLevel + '\'' +
				", custAddress='" + custAddress + '\'' +
				", custPhone='" + custPhone + '\'' +
				'}';
	}
}
