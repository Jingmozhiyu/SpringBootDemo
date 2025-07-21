package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.pojo.dto.ResponseMessage;
import com.example.springbootdemo.pojo.dto.UserDto;
import com.example.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController    // Return JSON text
@RequestMapping("/user")    // localhost:8088/user/**
public class UserController {

    @Autowired
    IUserService userService;

    // REST

    // Create
    @PostMapping   // URL: localhost:8088/user
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user){    // @RequestBody: Json to Object
        User newUser = userService.add(user);
        return ResponseMessage.success(newUser);
    }

    // Read
    @GetMapping("/{userId}")    // URL: localhost:8088/user/1
    public ResponseMessage get(@PathVariable Integer userId){
        User newUser = userService.getUser(userId);
        return ResponseMessage.success(newUser);
    }

    // Update
    @PutMapping
    public ResponseMessage edit(@Validated @RequestBody UserDto user){
        User newUser = userService.edit(user);
        return ResponseMessage.success(newUser);
    }
    // Delete
    @DeleteMapping("/{userId}")
    public ResponseMessage delete(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return ResponseMessage.success();
    }
}
