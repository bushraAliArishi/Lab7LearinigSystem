package com.example.learinigsystem.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "The ID must not be empty")
    @Size(min = 4, message = "The ID must contain more than 4 characters")
    private String id;
    @NotEmpty(message = "The course name must not be empty")
    @Size(min = 4, message = "The course name must contain more than 4 characters")
    private String name;

    @PositiveOrZero(message = "The capacity must be a positive number")
    private int capacity;

    @PositiveOrZero(message = "The score must be a positive number")
    private double score;

    private boolean isPass;

    private int courseLevel;
}
