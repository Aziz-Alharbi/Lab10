package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {

    //▪ id:
    //- Must be Generated.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //▪ title:
    //- Cannot be null.
    //- Length must be more than 4 characters.

    @NotEmpty(message = "title shouldn't be null")
    @Size(min = 5)
    @Column(columnDefinition = "varchar(40) not null")
    private String title;

    //▪ description:
    //- Cannot be null.

    @NotEmpty(message = "description shouldn't be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    // ▪ location:
    //- Cannot be null.
    //

    @NotEmpty(message = "location shouldn't be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String location;

    // ▪ salary:
    //- Cannot be null.
    //- Must be a non-negative number.

    @NotNull(message = "salary shouldn't be null")
    @Positive
    @Column(columnDefinition = "double not null")
    private Double salary;


    //▪ postingDate

    private LocalDate postingDate;










}
