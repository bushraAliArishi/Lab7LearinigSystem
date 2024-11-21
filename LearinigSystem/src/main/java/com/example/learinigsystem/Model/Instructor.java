package com.example.learinigsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Instructor {

    private boolean isLeave=false;

    @NotEmpty(message = "The ID must not be empty")
    @Size(min = 4, message = "The ID must contain more than 4 characters")
    private String id;

    @NotEmpty(message = "The instructor name must not be empty")
    @Size(min = 4, message = "The name must contain more than 4 characters")
    private String name;

    @NotEmpty(message = "The phone number must not be empty")
    @Size(min = 10, max = 10, message = "The phone number must contain 10 digits")
    private String phoneNumber;

    @Email(message = "The email is not valid")
    @NotEmpty(message = "The email value mustn't be empty")
    private String email;

    @NotNull(message = "Date of birth can't be empty")
    @Past(message = "Date of birth can't be the present date or future date")
    private LocalDate DOB;

    @NotEmpty(message = "Address can't be empty")
    @Size(max = 50, message = "The address can't be more than 50 characters")
    private String address;
    @PositiveOrZero
    private int annualLeave;
    @NotEmpty(message = "The instructor must have a course")
    private Course course;
}
