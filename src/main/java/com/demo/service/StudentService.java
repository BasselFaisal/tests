package com.demo.service;

import com.demo.model.Student;
import com.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepository;

    public Student saveStudent(){

        Student student = new Student(
                1L, "John Doe", Student.Gender.MALE, 1);

        student = studentRepository.save(student);

        return student;
    }

    public Student fetchStudent(){
        Student student =
                studentRepository.findById(1L).get();
        return student;
    }
}
