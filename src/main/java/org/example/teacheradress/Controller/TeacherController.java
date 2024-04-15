package org.example.teacheradress.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiResponse;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    Logger logger= LoggerFactory.getLogger(TeacherController.class);
    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){

        logger.info("inside get all teacher");
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        logger.info("inside add teacher");
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id ,@RequestBody @Valid Teacher teacher){
        logger.info("inside update teacher");
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id ){
        logger.info("inside delete teacher");
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable Integer id){
        logger.info("inside search teacher");
        Teacher t=teacherService.searchTeacher(id);
        return ResponseEntity.status(200).body(t);
    }
}
