package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    //▪ id:
    //- Must be Generated.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    //▪ name:
    //- Cannot be null.
    //- Length must be more than 4 characters.
    //- Must contain only characters (no numbers).

    @NotEmpty(message = "name shouldn't be null")
    @Size(min= 5)
    @Pattern(regexp = "^[A-Za-z]+$")
    @Column(columnDefinition ="varchar(15) not null")
    private String name;



    //▪ email:
    //- Must be a valid email format.
    //- Must be unique.


    @Email
    @Column(columnDefinition = "varchar(100) unique not null")
    private String email;

    //▪ password:
    //- Cannot be null.

    @NotEmpty(message = "password shouldn't be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    // ▪ age:
    //- Cannot be null.
    //- Must be a number.
    //- Must be more than 21.

    @NotNull(message = "age shouldn't be null")
    @Min(22)
    @Column(columnDefinition = "int not null")
    private Integer age;



    //▪ role:
    //- Cannot be null.
    //- Must be either "JOB_SEEKER" or "EMPLOYER" only.

    @NotEmpty(message = "role shouldn't be null")
    @Pattern(regexp = "^(Job Seeker|Employer)$")
    @Column(columnDefinition = "ENUM('Job Seeker', 'Employer') NOT NULL")
    private String role;




}
