package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.User;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, Errors errors) {

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User has been added successfully !"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid User user, @PathVariable Integer id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated = userService.updateUser(id, user);

        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("User has been updated successfully !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User is not found !"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        Boolean isDeleted = userService.delete(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("User has been deleted successfully !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User is not found !"));
    }






    }
