package org.example.teacheradress.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiResponse;
import org.example.teacheradress.Model.Course;
import org.example.teacheradress.Model.Student;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;
    Logger logger= LoggerFactory.getLogger(CourseController.class);
    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        logger.info("inside get all courses");
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        logger.info("inside add course");
        courseService.addCourse(course);
        return  ResponseEntity.status(200).body(new ApiResponse("course added"));
    }

    @PutMapping("/update/{course_id}")
    public ResponseEntity updateCourse(@PathVariable Integer course_id,@RequestBody @Valid Course course){
        logger.info("inside update course");
        courseService.updateCourse(course_id,course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated"));
    }
    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity deleteCourse(@PathVariable Integer course_id){
        logger.info("inside delete course");
        courseService.deleteCourse(course_id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted"));
    }

    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        logger.info("inside assign teacher to course");
        courseService.assignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Assign DONE!"));
    }
    @GetMapping("/search-teacher-course/{course_id}")
    public ResponseEntity searchTeacherByCourse(@PathVariable Integer course_id){
        logger.info("inside search teacher name by course ID ");
        String teacher=courseService.searchTeacherByCorse(course_id);
        return ResponseEntity.status(200).body("the teacher for this course :"+teacher);
    }


    @GetMapping("/search-student-course/{course_id}")
    public ResponseEntity searchByCourse(@PathVariable Integer course_id){
        logger.info("inside search student by course ID ");
        List<Student> list=courseService.searchByCourse(course_id);
        return ResponseEntity.status(200).body(list);
    }
}
