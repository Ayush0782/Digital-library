package org.library.DigitalLibrary.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Student {

    private int id;
    private int studentId;
    private String name;
    private String email;
    private  String phoneNo;
    private List<Book> books;
    private StudentType studentType;
    Date createdOn;
    Date updatedOn;


}
