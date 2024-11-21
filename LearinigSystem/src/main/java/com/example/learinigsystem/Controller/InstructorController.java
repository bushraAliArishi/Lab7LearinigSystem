package com.example.learinigsystem.Controller;

import com.example.learinigsystem.ApiResponse.ApiResponse;
import com.example.learinigsystem.Model.Course;
import com.example.learinigsystem.Model.Instructor;
import com.example.learinigsystem.Service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/display")
    public ResponseEntity getInstructors() {
        return ResponseEntity.status(200).body(instructorService.getInstructors());
    }
    @PostMapping("/add")
    public ResponseEntity addInstructor(@RequestBody @Valid Instructor instructor) {
        instructorService.addInstructor(instructor);
        return ResponseEntity.status(200).body(new ApiResponse("Instructor added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateInstructor(@PathVariable String id, @RequestBody @Valid Instructor instructor) {
        boolean updated = instructorService.updateInstructor(id, instructor);
        if (updated) {
            return ResponseEntity.status(200).body(new ApiResponse("Instructor updated successfully"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("Instructor not found"));
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInstructor(@PathVariable String id) {
        boolean deleted = instructorService.deleteInstructor(id);
        if (deleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Instructor deleted successfully"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("Instructor not found"));
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity searchInstructor(@PathVariable String name) {
        Instructor instructor = instructorService.searchInstructor(name);
        if (instructor != null) {
            return ResponseEntity.status(200).body(instructor);
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("Instructor not found"));
        }
    }
    @PutMapping("/leave/{id}/{days}")
    public ResponseEntity goOnLeave(@PathVariable String id,@PathVariable int days){
        boolean updated = instructorService.goOnLeave(id,days);
        if (updated) {
            return ResponseEntity.status(200).body(new ApiResponse("Instructor updated successfully"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("Instructor not found"));
        }

    }
    @PutMapping("/course/{id}")
    public ResponseEntity updateCourse(@PathVariable String id, @RequestBody Course course, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean updated = instructorService.updateCourse(id,course);
        if (updated) {
            return ResponseEntity.status(200).body(new ApiResponse("Instructor updated successfully"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("Instructor not found"));
        }

    }
}
