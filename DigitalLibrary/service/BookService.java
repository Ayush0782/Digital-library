package org.library.DigitalLibrary.service;

import org.library.DigitalLibrary.exception.BookAlreadyPresent;
import org.library.DigitalLibrary.model.Author;
import org.library.DigitalLibrary.model.Book;
import org.library.DigitalLibrary.repository.AuthorDao;
import org.library.DigitalLibrary.repository.BookDao;
import org.library.DigitalLibrary.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;


    @Autowired
    AuthorDao authorDao;


    public Book createBookInDatabase(CreateBookRequest createBookRequest){

        String bookId = createBookRequest.getBookId();
        String bookName = createBookRequest.getBookName();
        String bookType = createBookRequest.getBookType().name();
        String authorEmail = createBookRequest.getAuthorEmail();

        Book bookResult = null;

        try{

            int status = bookDao.findBookById(bookId);
            if (status >0){
                throw new BookAlreadyPresent("Book is Already present in the database");
            }

            int result = bookDao.createBookInDatabase(bookId,bookName,bookType,authorEmail);
            if (result<=0){
                return null;
            }

            boolean isAuthorExist = false;
            try{
                Author authorExist = authorDao.findAuthorById(authorEmail);
                isAuthorExist = true;
            }
            catch (Exception e){
                isAuthorExist = false;
            }
            if (isAuthorExist == true){
                return bookResult;
            }
            authorDao.createAuthor(CreateBookRequest.toAuthor(createBookRequest));



        } catch (Exception exception) {

            throw new RuntimeException("Error in Creating Book" , exception);
        }

        return bookResult;

    }
}
