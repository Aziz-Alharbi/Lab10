package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Service.JobPostService;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity<?> getPosts(){
        return ResponseEntity.status(200).body(jobPostService.getPosts());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody @Valid JobPost jobPost, Errors errors) {

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        jobPostService.addPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job post has been added successfully !"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@RequestBody @Valid JobPost jobPost, @PathVariable Integer id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated = jobPostService.updatePost(id, jobPost);

        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Job post has been updated successfully !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job post is not found !"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id){

        Boolean isDeleted = jobPostService.deletePost(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Job post has been deleted successfully !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job post is not found !"));
    }
}
