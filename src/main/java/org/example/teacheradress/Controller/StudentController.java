package org.example.teacheradress.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiResponse;
import org.example.teacheradress.Model.Student;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    Logger logger= LoggerFactory.getLogger(StudentController.class);


    @GetMapping("/get")
    public ResponseEntity getAllStudent(){

        logger.info("inside get all Student");
        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        logger.info("inside add Student");
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id ,@RequestBody @Valid Student student){
        logger.info("inside update Student");
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body(new ApiResponse("student update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id ){
        logger.info("inside delete Student");
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
    }

    @PutMapping("assign/{student_id}/{course_id}")
    public ResponseEntity assign(@PathVariable Integer student_id,@PathVariable Integer course_id){
        logger.info("inside assign Student");
       studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign successfully"));

    }


    @PutMapping("change/{student_id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer student_id,@PathVariable String major){
        studentService.changeMajor(student_id,major);
        return ResponseEntity.status(200).body(new ApiResponse("change successfully"));

    }

}
