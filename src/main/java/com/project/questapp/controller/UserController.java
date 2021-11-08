package com.project.questapp.controller;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;
import com.project.questapp.services.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
        //private UserRepository userRepository;
    //    public UserController (UserRepository userRepository){
    //        this.userRepository= userRepository;
    //    }
    private final UserService userService;
    public UserController(UserService userService){
        this.userService= userService;
    }
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }
//    @GetMapping("{userId}")
//    public User getOneUser(@PathVariable Long userId){
//        return userService.getOneUser(userId);
//    }
    @PutMapping("{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId, newUser);
        }
    @DeleteMapping("{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }
}
