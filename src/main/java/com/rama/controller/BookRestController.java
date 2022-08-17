package com.rama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rama.bindings.Book;
import com.rama.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@PostMapping(value="/addbook", consumes = {"application/json"})
	public ResponseEntity<String> addBook(@RequestBody Book book)
	{
		String msg=null;
		boolean isSaved = bookService.saveBook(book);
		if (isSaved) {
			msg="Book saved ";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);	
		}else {
			msg="failed save book ";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_GATEWAY);
		}
		
	}
}
