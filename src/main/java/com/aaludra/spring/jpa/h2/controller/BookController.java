package com.aaludra.spring.jpa.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaludra.spring.jpa.h2.service.BookService;
import com.aaludra.spring.jpa.h2.view.BookinputView;
import com.aaludra.spring.jpa.h2.view.BookoutputView;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookserve;

	@PostMapping("/create")
	public ResponseEntity<BookoutputView> createBook(@RequestBody BookinputView bookin) {

		return new ResponseEntity<>(bookserve.createbook(bookin), HttpStatus.CREATED);

	}

	@GetMapping("/get/list")
	public ResponseEntity<List<BookoutputView>> getAllbooks() {

		List<BookoutputView> bookoutArr = bookserve.getAllbooks();
		if (bookoutArr.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bookoutArr, HttpStatus.OK);
	}

	@GetMapping("/getbook/{bookid}")
	public ResponseEntity<BookoutputView> getBookByid(@PathVariable long bookid) {

		return new ResponseEntity<>(bookserve.getBookbyId(bookid), HttpStatus.OK);

	}

	@PutMapping("/update/{bookid}")
	public ResponseEntity<BookoutputView> updateBook(@PathVariable long bookid, @RequestBody BookinputView bookin) {
		try {

			BookoutputView bookout = bookserve.updateBook(bookid, bookin);
			if (bookout != null) {
				return new ResponseEntity<>(bookout, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping("/delete/{bookid}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable long bookid) {
		bookserve.deleteBook(bookid);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
