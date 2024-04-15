package org.example.teacheradress.Service;

import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiException;
import org.example.teacheradress.Model.Course;
import org.example.teacheradress.Model.Student;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Repository.CourseRepository;
import org.example.teacheradress.Repository.StudentRepository;
import org.example.teacheradress.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
            }

            public void updateCourse(Integer id,Course course){
        Course c=courseRepository.findCourseById(id);
        if (c==null){
            throw new ApiException("not found course id");
        }
        c.setName(course.getName());
        courseRepository.save(c);
            }

            public void deleteCourse(Integer course_id){
        Course c=courseRepository.findCourseById(course_id);
        if (c==null){
            throw new ApiException("not found course id");
        }
        courseRepository.delete(c);
            }

            public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
                Teacher teacher=teacherRepository.findTeacherById(teacher_id);
                Course course=courseRepository.findCourseById(course_id);
                if (teacher==null || course==null){
                    throw new ApiException("cannot assign");
                }
                course.setTeacher(teacher);
                courseRepository.save(course);
            }

    public String searchTeacherByCorse(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);
        Teacher teacher=teacherRepository.findTeacherById(course.getTeacher().getId());
        if (course==null){
            throw new ApiException("not found course id");
        }
        if (teacher==null){
            throw new ApiException("not found teacher assigned to this course ");
        }

        return teacher.getName();

    }

    public List<Student> searchByCourse(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);
        if (course==null){
            throw new ApiException("not found course id");
        }
      List<Student> stdList=studentRepository.findStudentsByCourses(course);

        return stdList;
    }





}
