package com.aaludra.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

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

import com.aaludra.spring.jpa.h2.model.BookModel;
import com.aaludra.spring.jpa.h2.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookRepository bookrepo;

	@PostMapping("/create")
	public ResponseEntity<BookModel> createBook(@RequestBody BookModel book) {
		try {
			return new ResponseEntity<>(bookrepo.save(book), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/get/list")
	public ResponseEntity<List<BookModel>> getAllbooks() {
		List<BookModel> list = bookrepo.findAll();
		try {
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<BookModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/getid/{id}")
	public ResponseEntity<BookModel> getBookByid(@PathVariable long id) {
		Optional<BookModel> book = bookrepo.findById(id);
		if (book.isPresent()) {
			return new ResponseEntity<BookModel>(book.get(), HttpStatus.OK);
		}
		return new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<BookModel> updateBook(@PathVariable long id, @RequestBody BookModel book) {
		Optional<BookModel> book1 = bookrepo.findById(id);

		if (book1.isPresent()) {
			BookModel bm = book1.get();
			bm.setName(book.getName());
			bm.setAuthor(book.getAuthor());
			bm.setDescription(book.getDescription());
			bm.setCatagory(book.getCatagory());

			return new ResponseEntity<BookModel>(bookrepo.save(bm), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BookModel> deleteBook(@PathVariable long id) {

		try {
			bookrepo.deleteById(id);
			return new ResponseEntity<BookModel>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BookModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
