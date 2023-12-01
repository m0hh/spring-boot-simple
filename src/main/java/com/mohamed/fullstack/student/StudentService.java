package com.mohamed.fullstack.student;

import com.mohamed.fullstack.EmailValidator;
import com.mohamed.fullstack.exception.ApiRequestExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;

        this.emailValidator = emailValidator;
    }


    List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }

    void addNewStudent(Student student) {
        addNewStudent(null,student);
        // verify that email is not taken
    }
    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId  = Optional.ofNullable(studentId).orElse(UUID.randomUUID());
        // verify that email is not taken
        if (!emailValidator.test(student.getEmail())){
            throw new ApiRequestExcetion(student.getEmail() + " is not Valid");
        }
        if (studentDataAccessService.isEmailTaken(student.getEmail())){
            throw  new ApiRequestExcetion(student.getEmail() + " is taken");
        }
        studentDataAccessService.insertStudent(newStudentId, student);
    }
}
