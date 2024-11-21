package com.example.learinigsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "The ID must not be empty")
    @Size(min = 4, message = "The ID must contain more than 4 characters")
    private String id;
    @NotEmpty(message = "The name must not be empty")
    @Size(min = 4, message = "The name must contain more than 4 characters")
    private String name;

    @NotEmpty(message = "The phone number must not be empty")
    @Size(min = 10, max = 10, message = "The phone number must contain 10 digits")
    private String phoneNumber;

    @NotEmpty(message = "The address must not be empty")
    @Size(max = 50, message = "The address must not be more than 50 characters")
    private String address;

    @NotNull(message = "Date of birth can't be empty")
    @Past(message = "Date of birth can't be the present date or future date")
    private LocalDate DOB;

    @Email(message = "The email is not valid")
    @NotEmpty(message = "The email must not be empty")
    private String email;

    @Positive(message = "The GPA must be a positive value")
    private double GPA;

    private boolean isGraduate;

    private int level;

}
