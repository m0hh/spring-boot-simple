package com.mohamed.fullstack.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> selectAllStudents() {
        String sql = "SELECT student_id, first_name, last_name, email, gender "+
                "FROM student";
        List<Student> students = jdbcTemplate.query(sql, mapStudentFromDb());
        return students;
    }

    int insertStudent(UUID studentId, Student student) {
        String sql = "INSERT INTO student "+
                "(student_id, first_name, last_name, email, gender) "+
                "VALUES(?,?,?,?,?::gender )";
        return jdbcTemplate.update(sql, studentId,
                student.getFristName(),
                student.getLastName(),
                student.getEmail(),
                student.getGender().name().toUpperCase());
    }
    private static RowMapper<Student> mapStudentFromDb() {
        return (rs, rowNum) -> {
            String studentIdStr = rs.getString("student_id");
            UUID studentID = UUID.fromString(studentIdStr);
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String genderStr = rs.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderStr);
            return new Student(
                    studentID,
                    firstName,
                    lastName,
                    email,
                    gender
            );
        };
    }

     boolean isEmailTaken(String email) {
        String sql = "SELECT EXISTS ( " +
                "SELECT 1 FROM student WHERE email = ?)";
        return jdbcTemplate.queryForObject(sql,new Object[] {email}, (rs,i) -> rs.getBoolean(1));
    }
}
