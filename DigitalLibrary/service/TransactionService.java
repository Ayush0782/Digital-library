package org.library.DigitalLibrary.service;


import org.library.DigitalLibrary.model.Book;
import org.library.DigitalLibrary.model.Transaction;
import org.library.DigitalLibrary.repository.BookDao;
import org.library.DigitalLibrary.repository.TransactionDao;
import org.library.DigitalLibrary.request.BookTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    BookDao bookDao;

    public Transaction createTransaction(BookTransactionRequest request){
        int row = transactionDao.issueBookToStudent(request);

        if (row<=0){
            return null;
        }


        Book book = bookDao.findBookById(request.getBookId());

        Transaction transaction = new Transaction();
        transaction.setBook(book);
        return transaction;
    }
}
