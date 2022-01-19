package com.aaludra.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "tbl_book")
@Entity
@Getter
@Setter
@ToString
public class BookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Author")
	private String author;

	@Column(name = "Description")
	private String description;

	@Column(name = "Catagory")
	private String catagory;

	@Column(name = "Price")
	private int price;

	@CreationTimestamp
	@Column(name = "Date")
	private Date date;

}
