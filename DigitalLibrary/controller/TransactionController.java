package org.library.DigitalLibrary.controller;


import org.library.DigitalLibrary.model.Transaction;
import org.library.DigitalLibrary.request.BookTransactionRequest;
import org.library.DigitalLibrary.response.TransactionResponse;
import org.library.DigitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/book/initiate")
    public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody BookTransactionRequest bookTransactionRequest){

        TransactionResponse transactionResponse = new TransactionResponse();
        if(bookTransactionRequest == null){
            transactionResponse.setErrCode("FAILED");
            transactionResponse.setMessage("Request is Empty");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
        }

       Transaction transaction = transactionService.createTransaction(bookTransactionRequest);
        if (transaction == null){
            transactionResponse.setErrCode("FAILED");
            transactionResponse.setMessage("Not Completed");
            return new ResponseEntity<>(transactionResponse,HttpStatus.OK);
        }

        transactionResponse.setTransactionType(bookTransactionRequest.getRequestType());
        transactionResponse.setBookName(transaction.getBook().getBookName());
        transactionResponse.setMessage("Book" + bookTransactionRequest.getRequestType());
        transactionResponse.setErrCode("SUCCESS");

        return new ResponseEntity<>(transactionResponse,HttpStatus.CREATED);


    }



}
