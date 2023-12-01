package com.mohamed.fullstack.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class Student {

    private  final UUID studentId;
    @NotBlank
    private  final String  fristName;
    @NotBlank
    private  final String  lastName;
    // Add custom email validation
    @NotBlank
    private  final String  email;
    @NotNull
    private  final Gender  gender;


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
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

    public Gender getGender() {
        return gender;
    }


    public Student(@JsonProperty("studentId") UUID studentId,
                   @JsonProperty("fristName") String fristName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("email") String email,
                   @JsonProperty("gender") Gender gender) {
        this.studentId = studentId;
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    enum Gender {
        MALE,FEMALE
    }

}
