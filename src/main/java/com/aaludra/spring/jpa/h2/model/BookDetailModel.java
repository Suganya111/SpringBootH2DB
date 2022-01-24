package com.aaludra.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tbl_bookdetail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailModel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Version")
	private String version;

	@Column(name = "Author_Profile")
	private String authorProfile;

	@Column(name = "Current_Stock ")
	private int stock;

	@Column(name = "Published_Date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date publisheddate;

	@JoinColumn(name = "book_id")
	@OneToOne(cascade = CascadeType.ALL)
	private BookModel bookmodel;

}
