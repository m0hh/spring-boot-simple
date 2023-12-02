package com.mohamed.fullstack.StudentCourse;

import com.mohamed.fullstack.exception.ApiRequestExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    private final StudentCourseDataAccessService studentCourseDataAccessService;

    @Autowired
    public StudentCourseService(StudentCourseDataAccessService studentCourseDataAccessService) {
        this.studentCourseDataAccessService = studentCourseDataAccessService;
    }

    List<StudentCourse> getStudentById(String studentUUID){
        if (studentUUID == null){
            throw new ApiRequestExcetion("Not found");
        }
        return studentCourseDataAccessService.getById(studentUUID);
    }
}
