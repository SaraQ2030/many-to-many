package org.example.teacheradress.Service;

import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiException;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher t=teacherRepository.findTeacherById(id);
        if (t==null){
            throw new ApiException("Not found user id");
        }
        t.setAddress(teacher.getAddress());
        t.setAge(teacher.getAge());
        t.setName(teacher.getName());
        t.setSalary(teacher.getSalary());
        t.setEmail(teacher.getEmail());
        teacherRepository.save(t);
    }
    public void deleteTeacher(Integer id){
        Teacher t=teacherRepository.findTeacherById(id);
        if (t==null){
            throw new ApiException("Not found user id");
        }
        teacherRepository.delete(t);
    }

    public Teacher searchTeacher(Integer id){
        Teacher t=teacherRepository.findTeacherById(id);
        if (t==null){
            throw new ApiException("not found teacher");
        }
        return t;
    }
}
