package com.cookie312.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cst_linkman")
public class LinkMan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lkm_id")
	private  Long lkmId;
	@Column(name = "lkm_name")
	private String lkmName;
	@Column(name = "lkm_gender")
	private String lkmGender;
	@Column(name = "lkm_phone")
	private String lkmPhone;
	@Column(name = "lkm_mobile")
	private String lkmMobile;
	@Column(name = "lkm_email")
	private String lkmEmail;
	@Column(name = "lkmPosition")
	private String lkm_position;
	@Column(name = "lkm_memo")
	private String lkmMemo;

	@ManyToOne(targetEntity = Customer.class,   fetch=FetchType.LAZY)    //对应的类
	@JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
	private Customer customer;

	public Long getLkmId() {
		return lkmId;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public String getLkmName() {
		return lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmGender() {
		return lkmGender;
	}

	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}

	public String getLkmPhone() {
		return lkmPhone;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmEmail() {
		return lkmEmail;
	}

	public void setLkmEmail(String lkmEmail) {
		this.lkmEmail = lkmEmail;
	}

	public String getLkm_position() {
		return lkm_position;
	}

	public void setLkm_position(String lkm_position) {
		this.lkm_position = lkm_position;
	}

	public String getLkmMemo() {
		return lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "LinkMan{" +
				"lkmId=" + lkmId +
				", lkmName='" + lkmName + '\'' +
				", lkmGender='" + lkmGender + '\'' +
				", lkmPhone='" + lkmPhone + '\'' +
				", lkmMobile='" + lkmMobile + '\'' +
				", lkmEmail='" + lkmEmail + '\'' +
				", lkm_position='" + lkm_position + '\'' +
				", lkmMemo='" + lkmMemo + '\'' +
				'}';
	}
}
