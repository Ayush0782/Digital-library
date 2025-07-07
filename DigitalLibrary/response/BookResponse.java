package org.library.DigitalLibrary.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse extends Response{
    private String bookId;
    private String bookName;


}
