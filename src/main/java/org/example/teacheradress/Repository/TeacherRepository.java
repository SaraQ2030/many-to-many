package org.example.teacheradress.Repository;

import org.example.teacheradress.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
Teacher findTeacherById(Integer id);
}
