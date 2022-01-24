package com.aaludra.spring.jpa.h2.view;

import com.aaludra.spring.jpa.h2.model.BookDetailModel;
import com.aaludra.spring.jpa.h2.model.BookModel;
import com.aaludra.spring.jpa.h2.util.DateUtil;

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

	private String authorprofile;
	private String version;
	private String stock;
	private String publisheddate;

	public BookModel convertBook(BookinputView bookin) {

		BookModel bookmodel = new BookModel();
		bookmodel.setBookname(bookin.getBookname());
		bookmodel.setAuthor(bookin.getAuthor());
		bookmodel.setCatagory(bookin.getCatagory());
		bookmodel.setDescription(bookin.getDescription());
		bookmodel.setPrice(Integer.parseInt(bookin.getPrice()));

		return bookmodel;

	}

	public BookDetailModel convertBookedetail(BookinputView bookin) {
		BookDetailModel bookdetailmodel = new BookDetailModel();
		bookdetailmodel.setAuthorProfile(bookin.getAuthorprofile());
		bookdetailmodel.setStock(Integer.parseInt(bookin.getStock()));
		bookdetailmodel.setVersion(bookin.getVersion());
		bookdetailmodel.setPublisheddate(DateUtil.convertDate(bookin.getPublisheddate()));

		return bookdetailmodel;

	}
}
