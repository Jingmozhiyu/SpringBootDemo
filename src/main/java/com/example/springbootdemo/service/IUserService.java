package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.pojo.dto.UserDto;

public interface IUserService {
    /**
     * Insert users
     *
     * @param user user
     * @return new user
     */
    User add(UserDto user);

    /**
     * Inquire users
     * @param userId userId
     * @return userInfo
     */
    User getUser(Integer userId);

    /**
     * Edit users
     * @param userId userId
     * @param user user
     * @return updated user
     */
    User edit(Integer id, UserDto userDto);

    /**
     * Delete users
     *
     * @param userId userId
     */
    void deleteUser(Integer userId);
}
