package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.pojo.dto.UserDto;

public interface IUserService {
    /**
     * Insert users
     *
     * @param user
     * @return
     */
    User add(UserDto user);

    /**
     * Inquire users
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * Edit users
     * @param user
     * @return
     */
    User edit(UserDto user);

    /**
     * Delete users
     *
     * @param userId
     */
    void deleteUser(Integer userId);
}
