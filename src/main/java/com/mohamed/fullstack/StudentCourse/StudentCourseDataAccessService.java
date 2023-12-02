package com.mohamed.fullstack.StudentCourse;

import com.mohamed.fullstack.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentCourseDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentCourseDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<StudentCourse> getById(String uuidStr){
        UUID uuid = UUID.fromString(uuidStr);
        String sql = "SELECT * FROM student JOIN student_course USING (student_id) JOIN course USING(course_id) WHERE student_id= ?";
        List<StudentCourse> courses =  jdbcTemplate.query(sql, new Object[] {uuid}, (rs, i) -> {
            String studentIdStr = rs.getString("student_id");
            UUID studentID = UUID.fromString(studentIdStr);
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String genderStr = rs.getString("gender").toUpperCase();
            String course_idStr = rs.getString("course_id");
            UUID course_id = UUID.fromString(course_idStr);
            String course_start_date = rs.getString("start_date");
            String  course_end_date = rs.getString("end_date");
            String course_gradeSTR = rs.getString("grade");
            Integer course_grade = null;
            if (course_gradeSTR != null) {
                course_grade = Integer.parseInt(course_gradeSTR);
            }
            String course_name = rs.getString("name");
            String course_description = rs.getString("description");
            String course_department = rs.getString("department");
            String  teacher_name = rs.getString("teacher_name");
            return new StudentCourse(
                    studentID,
                    firstName,
                    lastName,
                    email,
                    genderStr,
                    course_id,
                    course_start_date,
                    course_end_date,
                    course_grade,
                    course_name,
                    course_description,
                    course_department,
                    teacher_name

            );
        });
        return courses;

    }
}
