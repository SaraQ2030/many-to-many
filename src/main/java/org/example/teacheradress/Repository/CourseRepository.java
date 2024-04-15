package org.example.teacheradress.Repository;

import org.example.teacheradress.Model.Course;
import org.example.teacheradress.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);

}
