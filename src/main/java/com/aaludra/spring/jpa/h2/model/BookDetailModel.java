package com.aaludra.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tbl_bookdetail")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDetailModel {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Version")
	private String version;

	@Column(name = "Author_Profile")
	private String authorProfile;

	@Column(name = "Published_Date")
	private Date publishedDate;

	@Column(name = "Current_Stock ")
	private int stock;

}
