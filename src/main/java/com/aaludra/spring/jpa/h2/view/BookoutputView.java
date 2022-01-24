package com.aaludra.spring.jpa.h2.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aaludra.spring.jpa.h2.model.BookModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class BookoutputView {

	private String bookid;
	private String bookname;
	private String author;
	private String catagory;
	private String description;
	private String price;
	private String uploadeddate;

	private String id;
	private String stock;
	private String authorprofile;
	private String version;
	private String publisheddate;

	public BookoutputView reconvertBook(BookModel bm) {

		BookoutputView bookout = new BookoutputView();
		bookout.setBookid(String.valueOf(bm.getBookid()));

		bookout.setBookname(bm.getBookname());
		bookout.setAuthor(bm.getAuthor());
		bookout.setCatagory(bm.getCatagory());
		bookout.setDescription(bm.getDescription());
		bookout.setPrice(String.valueOf(bm.getPrice()));
		bookout.setUploadeddate(bm.getUploadeddate().toString());

		bookout.setId(String.valueOf(bm.getBookmodeldetail().getId()));
		bookout.setAuthorprofile(bm.getBookmodeldetail().getAuthorProfile());
		bookout.setVersion(bm.getBookmodeldetail().getVersion());
		bookout.setStock(String.valueOf(bm.getBookmodeldetail().getStock()));

		Date date = bm.getBookmodeldetail().getPublisheddate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		this.setPublisheddate(strDate);
		bookout.setPublisheddate(strDate);
		return bookout;
	}

}
