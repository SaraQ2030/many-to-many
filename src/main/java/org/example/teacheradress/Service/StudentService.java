package org.example.teacheradress.Service;

import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiException;
import org.example.teacheradress.Model.Course;
import org.example.teacheradress.Model.Student;
import org.example.teacheradress.Repository.CourseRepository;
import org.example.teacheradress.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer student_id, Student student){
        Student st=studentRepository.findStudentById(student_id);
        if (st==null){
            throw new ApiException("not found student");
        }
        st.setAge(student.getAge());
        st.setName(student.getName());
        st.setMajor(student.getMajor());
        st.setCourses(student.getCourses());
        studentRepository.save(st);
    }

    public void deleteStudent(Integer std_id){
        Student student=studentRepository.findStudentById(std_id);
        if (student==null){
            throw new ApiException("not found student");
        }
        studentRepository.delete(student);
    }


    public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student  student=studentRepository.findStudentById(student_id);
       Course course=courseRepository.findCourseById(course_id);
        if (student==null ||  course==null){
            throw new ApiException("cant assign");
        }
        course.getStudents().add(student);
        student.getCourses().add(course);
        studentRepository.save(student);
        courseRepository.save(course);
            }

            public void changeMajor(Integer std_id,String major){
        Student std=studentRepository.findStudentById(std_id);
      //  Course course=courseRepository.findCourseById();
        if (std==null){
            throw new ApiException("not found student id");
        }
if (major.equalsIgnoreCase(std.getMajor())){
    throw new ApiException("this is the current major");
}
        std.setMajor(major);
 std.getCourses().clear();
         studentRepository.save(std);
            }



}
