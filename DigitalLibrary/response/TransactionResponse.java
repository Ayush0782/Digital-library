package org.library.DigitalLibrary.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.library.DigitalLibrary.model.Book;
import org.library.DigitalLibrary.model.TransactionType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends Response {
    private String transactionType;
    private String bookName;



}
