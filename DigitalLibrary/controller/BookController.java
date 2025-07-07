package org.library.DigitalLibrary.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.library.DigitalLibrary.model.Book;
import org.library.DigitalLibrary.request.CreateBookRequest;
import org.library.DigitalLibrary.response.BookResponse;
import org.library.DigitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
@NoArgsConstructor
@AllArgsConstructor
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = "/create/book",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest createBookRequest){

        BookResponse bookResponse = new BookResponse();

        if (createBookRequest == null){
            bookResponse.setErrCode("FAILED");
            bookResponse.setMessage("Request is empty");
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }

        Book book = bookService.createBookInDatabase(createBookRequest);

        if(book == null){
            bookResponse.setErrCode("FAILED");
            bookResponse.setMessage("Data Not Inserted");
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }

        bookResponse.setErrCode("SUCCESS");
        bookResponse.setMessage("BOOK Inserted IN DATABASE");
        bookResponse.setBookId(book.getBookId()+"");
        bookResponse.setBookName(book.getBookName());

        return new ResponseEntity<>(bookResponse,HttpStatus.CREATED);



    }
}
