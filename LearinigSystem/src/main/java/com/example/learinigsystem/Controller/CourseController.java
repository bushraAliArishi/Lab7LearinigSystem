package com.example.learinigsystem.Controller;



import com.example.learinigsystem.ApiResponse.ApiResponse;
import com.example.learinigsystem.Model.Course;
import com.example.learinigsystem.Service.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
    @RestController
    @RequestMapping("/api/v1/course")
    @RequiredArgsConstructor
    public class CourseController {

        private final CourseService courseService;

        @GetMapping("/display")
        public ResponseEntity getCourses() {
            return ResponseEntity.status(200).body(courseService.getCourses());
        }

        @PostMapping("/add")
        public ResponseEntity addCourse(@RequestBody @Valid Course course) {
            courseService.addCourse(course);
            return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateCourse(@PathVariable String id, @RequestBody @Valid Course course, Errors errors) {
            if (errors.hasErrors()){
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            }
            boolean updated = courseService.updateCourse(id, course);
            if (updated) {
                return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
            }
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteCourse(@PathVariable String id) {
            boolean deleted = courseService.deleteCourse(id);
            if (deleted) {
                return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
            }
        }

        @GetMapping("/search/{name}")
        public ResponseEntity searchCourse(@PathVariable String name) {
            Course course = courseService.searchCourse(name);
            if (course != null) {
                return ResponseEntity.status(200).body(course);
            } else {
                return ResponseEntity.status(200).body(new ApiResponse("Course not found"));
            }
        }
        @GetMapping("/displayfilter/{level}")
        public ResponseEntity getCoursesByLevel(@PathVariable int level){
            return ResponseEntity.status(200).body(courseService.getCoursesByLevel(level));
        }
        @PutMapping("/capacity/{id}/{value}")
        public ResponseEntity updatecapacity(@PathVariable String id , @PathVariable int value){

            boolean updated = courseService.updatecapacity(id, value);
            if (updated) {
                return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
            } else {
                return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
            }
        }





    }

