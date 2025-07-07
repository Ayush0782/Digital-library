package org.library.DigitalLibrary.request;


import lombok.Builder;
import lombok.Data;
import org.library.DigitalLibrary.model.StudentType;

@Data
@Builder
public class CreateStudentRequest {
    String studentId;
    String name;
    String email;
    String phoneNo;
    StudentType studentType;
}
