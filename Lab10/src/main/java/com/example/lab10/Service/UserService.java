package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //1. Get all Users: Retrieves a list of all Users.
    //2. Add a new User: Adds a new user to the system.
    //3. Update a User: Updates an existing user’s information.
    //4. Delete a User: Deletes a user from the system. Note: Verify that the user exists.


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user){

        User oldUser = userRepository.getById(id);

        if(oldUser == null){
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        oldUser.setRole(user.getRole());

        userRepository.save(oldUser);
        return true;
    }

    public Boolean delete(Integer id){

        User user = userRepository.getById(id);
        if(!(user == null)){
            userRepository.delete(user);
            return true;
        }
        return false;
    }


}
