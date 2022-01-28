package com.aaludra.spring.jpa.h2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

	private String version;

	private String authorProfile;

	private int stock;

	private String bookname;

	private String author;

	private String description;

	private String catagory;

	private int price;

	// private Timestamp publisheddate;

}
