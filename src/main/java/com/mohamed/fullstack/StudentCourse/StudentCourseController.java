package com.mohamed.fullstack.StudentCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("student_course")
public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping(path = "{studentId}")
    public List<StudentCourse>  getStudentCourse(@PathVariable("studentId") String studentId){
        return studentCourseService.getStudentById(studentId);

    }
}
