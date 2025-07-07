package org.library.DigitalLibrary.service;


import org.library.DigitalLibrary.model.Student;
import org.library.DigitalLibrary.model.StudentType;
import org.library.DigitalLibrary.repository.StudentDao;
import org.library.DigitalLibrary.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public Student createStudent(CreateStudentRequest Request){

        String id = Request.getStudentId();
        String type = Request.getStudentType().toString();
        String name = Request.getName();
        String email = Request.getEmail();
        String phone = Request.getPhoneNo();

        Student student = Student.builder().studentId(Integer.parseInt(id)).studentType(StudentType.valueOf(type))
                .email(email).name(name).phoneNo(phone).build();


        int result = studentDao.createStudentIndatabase(student);
        if (result>0){
            System.out.println("Data has been inserted successfully");
            return student;
        }

        return null;


    }
}
