package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {

    //▪ id:
    //- Must be Generated.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //▪ userId:
    //- Cannot be null.

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer userId;


    // ▪ jobPostId:
    //- Cannot be null.

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer jobPostingId;


}
