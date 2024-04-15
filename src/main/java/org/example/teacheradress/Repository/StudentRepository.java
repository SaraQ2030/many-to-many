package org.example.teacheradress.Repository;

import org.example.teacheradress.Model.Course;
import org.example.teacheradress.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);

    List<Student> findStudentsByCourses(Course course);
}
