package com.aaludra.spring.jpa.h2.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BookinputView {
	private String bookname;
	private String author;
	private String catagory;
	private String description;
	private String price;
	private String uploadeddate;

	private String authorprofile;
	private String version;
	private String stock;
	private String publisheddate;

}
