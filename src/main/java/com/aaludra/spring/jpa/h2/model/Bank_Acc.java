package com.aaludra.spring.jpa.h2.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Acc")
public class Bank_Acc {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="acc_no")
	private long acc_no;
	@Column(name="balance")
	private BigDecimal balance;
	@Column(name="joindate")
	private Date joindate;
	@Column(name="acc_type")
	private String acc_type;
	public Bank_Acc() {
		
	}
public Bank_Acc(long id,String name,long acc_no,BigDecimal balance,Date joindate,String acc_type) {
	this.id=id;
	this.name=name;
	this.acc_no=acc_no;
	this.balance=balance;
	this.joindate=joindate;
	this.acc_type=acc_type;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public String toString() {
		return "ID:"+id+"Name:"+name+"Acc_No.:"+acc_no+"Balance:"+balance+"JoinDate:"+joindate+"Acc_Type:"+acc_type;
		
	}

}
