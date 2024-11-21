package com.example.learinigsystem.Controller;

import com.example.learinigsystem.ApiResponse.ApiResponse;
import com.example.learinigsystem.Model.Student;
import com.example.learinigsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/v1/student")
    @RequiredArgsConstructor
    public class StudentController {

        private final StudentService studentService;

        @GetMapping("/display")
        public ResponseEntity getStudents() {
            return ResponseEntity.status(200).body(studentService.getStudents());
        }
        @PostMapping("/add")
        public ResponseEntity addStudent(@RequestBody @Valid Student student,Errors errors) {
            if (errors.hasErrors()){
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            }
            studentService.addStudent(student);
            return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
        }
        @PutMapping("/update/{id}")
        public ResponseEntity updateStudent(@PathVariable String id, @RequestBody @Valid Student student, Errors errors) {
            if (errors.hasErrors()){
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            }
            boolean updated = studentService.updateStudent(id, student);
            if (updated) {
                return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
            }
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteStudent(@PathVariable String id) {
            boolean deleted = studentService.deleteStudent(id);
            if (deleted) {
                return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
            }
        }


        @GetMapping("/search/{id}")
        public ResponseEntity searchStudent(@PathVariable String id) {
            Student student = studentService.searchStudent(id);
            if (student != null) {
                return ResponseEntity.status(200).body(student);
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
            }
        }

        @GetMapping("/level/{level}")
        public ResponseEntity getStudentsByLevel(@PathVariable int level) {

            return ResponseEntity.status(200).body(studentService.getStudentsByLevel(level));
        }

        @PutMapping("/graduate/{id}")
        private ResponseEntity studentGraduate(@PathVariable String id){
            boolean updated = studentService.studentGraduate(id);
            if (updated) {
                return ResponseEntity.status(200).body(new ApiResponse("Student graduated "));
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
            }
        }

    }

