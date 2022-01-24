package com.aaludra.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_book")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private long bookid;

	@Column(name = "Book_Name")
	private String bookname;

	@Column(name = "Author")
	private String author;

	@Column(name = "Description")
	private String description;

	@Column(name = "Catagory")
	private String catagory;

	@Column(name = "Price")
	private int price;

	@CreationTimestamp
	@Column(name = "Uploades_Date")
	private Date uploadeddate;

	@OneToOne(mappedBy = "bookmodel", cascade = CascadeType.ALL)
	private BookDetailModel bookmodeldetail;

}
