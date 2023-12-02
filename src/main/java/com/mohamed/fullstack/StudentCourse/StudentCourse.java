package com.mohamed.fullstack.StudentCourse;

import java.util.UUID;

public class StudentCourse {
    private  final UUID studentId;
    private  final String  fristName;
    private  final String  lastName;
    // Add custom email validation
    private  final String  email;
    private  final String gender;

    private final UUID course_id;
    private final String course_start_date;
    private final String course_end_date;
    private final Integer course_grade;

    private final String  course_name;
    private final String course_description;
    private final String  course_department;
    private final String teacher_name;

    public StudentCourse(UUID studentId,
                         String fristName,
                         String lastName,
                         String email,
                         String gender,
                         UUID course_id,
                         String course_start_date,
                         String course_end_date,
                         Integer course_grade,
                         String course_name,
                         String course_description,
                         String course_department,
                         String teacher_name) {
        this.studentId = studentId;
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.course_id = course_id;
        this.course_start_date = course_start_date;
        this.course_end_date = course_end_date;
        this.course_grade = course_grade;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_department = course_department;
        this.teacher_name = teacher_name;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getFristName() {
        return fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public UUID getCourse_id() {
        return course_id;
    }

    public String getCourse_start_date() {
        return course_start_date;
    }

    public String getCourse_end_date() {
        return course_end_date;
    }

    public Integer getCourse_grade() {
        return course_grade;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public String getCourse_department() {
        return course_department;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

