package com.aaludra.spring.jpa.h2.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aaludra.spring.jpa.h2.model.BookDetailModel;
import com.aaludra.spring.jpa.h2.model.BookModel;
import com.aaludra.spring.jpa.h2.util.DateUtil;

public class BookMapper {
	public BookModel convertBook(BookinputView bookin) {

		BookModel bookmodel = new BookModel();
		bookmodel.setBookname(bookin.getBookname());
		bookmodel.setAuthor(bookin.getAuthor());
		bookmodel.setCatagory(bookin.getCatagory());
		bookmodel.setDescription(bookin.getDescription());
		bookmodel.setPrice(Double.parseDouble(bookin.getPrice()));
		bookmodel.setUploadeddate(DateUtil.convertStringToDate(bookin.getUploadeddate()));

		return bookmodel;

	}

	public BookDetailModel convertBookedetail(BookinputView bookin) {
		BookDetailModel bookdetailmodel = new BookDetailModel();
		bookdetailmodel.setAuthorProfile(bookin.getAuthorprofile());
		bookdetailmodel.setStock(Integer.parseInt(bookin.getStock()));
		bookdetailmodel.setVersion(bookin.getVersion());
		bookdetailmodel.setPublisheddate(DateUtil.convertStringToDate(bookin.getPublisheddate()));

		return bookdetailmodel;

	}

	public BookoutputView reconvertBook(BookModel bm) {

		BookoutputView bookout = new BookoutputView();
		bookout.setBookid(String.valueOf(bm.getBookid()));

		bookout.setBookname(bm.getBookname());
		bookout.setAuthor(bm.getAuthor());
		bookout.setCatagory(bm.getCatagory());
		bookout.setDescription(bm.getDescription());
		bookout.setPrice(DateUtil.doubleTocorrency(bm.getPrice() / 100));
		bookout.setUploadeddate(bm.getUploadeddate().toString());

		bookout.setId(String.valueOf(bm.getBookmodeldetail().getId()));
		bookout.setAuthorprofile(bm.getBookmodeldetail().getAuthorProfile());
		bookout.setVersion(bm.getBookmodeldetail().getVersion());
		bookout.setStock(String.valueOf(bm.getBookmodeldetail().getStock()));

		Date date = bm.getBookmodeldetail().getPublisheddate();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String strDate = dateFormat.format(date);
		bookout.setPublisheddate(strDate);
		return bookout;
	}

}
