package org.library.DigitalLibrary.request;


import lombok.*;
import org.library.DigitalLibrary.model.Author;
import org.library.DigitalLibrary.model.BookType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter


public class CreateBookRequest {
    String bookId;
    String bookName;
    BookType bookType;
    String authorName;
    String authorEmail;
    String authorNumber;


    public static Author toAuthor(CreateBookRequest request){
        Author author = Author.builder().email(request.getAuthorEmail())
                .name(request.getAuthorName()).phoneNo(request.getAuthorNumber()).build();
        return author;
    }
}
