package com.example.demo.service;

import com.example.demo.DTO.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public void createStudent(Student student){
        System.out.println("Student created");
        System.out.println(student.getName());
        System.out.println(student.getRoll());
 // response time badhane ke liyee

        try{
            Thread.sleep(2000);
        }
        catch(Exception e){}

    }
}
