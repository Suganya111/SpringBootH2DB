package com.aaludra.spring.jpa.h2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.aaludra.spring.jpa.h2.model.BookDetailModel;
import com.aaludra.spring.jpa.h2.model.BookModel;
import com.aaludra.spring.jpa.h2.repository.BookRepository;
import com.aaludra.spring.jpa.h2.view.BookinputView;
import com.aaludra.spring.jpa.h2.view.BookoutputView;
import com.aaludra.spring.jpa.h2.view.BookMapper;

@Service
public class BookService {
	@Inject
	BookRepository bookrepo;
	BookMapper inmap = new BookMapper();

	public BookoutputView createbook(BookinputView bookin) {

		BookModel bookmodel = inmap.convertBook(bookin);
		BookDetailModel bookdetailmodel = inmap.convertBookedetail(bookin);

		bookdetailmodel.setBookmodel(bookmodel);
		bookmodel.setBookmodeldetail(bookdetailmodel);

		return inmap.reconvertBook(bookrepo.save(bookmodel));

	}

	public List<BookoutputView> getAllbooks() {

		List<BookModel> list = bookrepo.findAll();
		List<BookoutputView> bookoutarr = new ArrayList<>();

		for (BookModel bookmodel : list) {
			BookoutputView bookoutputview = inmap.reconvertBook(bookmodel);
			bookoutarr.add(bookoutputview);
		}
		return bookoutarr;
	}

	public BookoutputView getBookbyId(long bookid) {

		Optional<BookModel> book = bookrepo.findById(bookid);
		BookoutputView bookout = new BookoutputView();
		if (book.isPresent()) {
			bookout = inmap.reconvertBook(book.get());
		}
		return bookout;

	}

	public BookoutputView updateBook(long bookid, BookinputView bookin) {

		Optional<BookModel> book1 = bookrepo.findById(bookid);

		if (book1.isPresent()) {
			BookModel bm = inmap.convertBook(bookin);
			BookDetailModel bdmodel = inmap.convertBookedetail(bookin);
			bm.setBookid(bookid);
			bdmodel.setId(bookid);
			bdmodel.setBookmodel(bm);
			bm.setBookmodeldetail(bdmodel);

			return inmap.reconvertBook(bookrepo.save(bm));
		}

		return null;
	}

	public void deleteBook(long bookid) {

		bookrepo.deleteById(bookid);

	}
}
