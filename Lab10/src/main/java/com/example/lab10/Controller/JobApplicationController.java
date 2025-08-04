package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobApplicationService;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/application")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;



    @GetMapping("/get")
    public ResponseEntity<?> getApplications(){
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApplication(@RequestBody @Valid JobApplication jobApplication, Errors errors) {

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        jobApplicationService.addJob(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("Job Application has been added successfully !"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateApplication(@RequestBody @Valid JobApplication jobApplication, @PathVariable Integer id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated = jobApplicationService.updateJob(id, jobApplication);

        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Job application has been updated successfully !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job application is not found !"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable Integer id){

        Boolean isDeleted = jobApplicationService.deleteJob(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Job application has been deleted successfully !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job application is not found !"));
    }
}
