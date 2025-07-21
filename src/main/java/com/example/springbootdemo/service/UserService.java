package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.pojo.dto.UserDto;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // Spring's Bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto userDto) {

        User user = new User();

        BeanUtils.copyProperties(userDto,user);

        return userRepository.save(user);
        // Call Repository Class
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() ->{
            throw new IllegalArgumentException("用户不存在，参数异常！");
        });
    }

    @Override
    public User edit(UserDto userDto) {

        User user = new User();

        BeanUtils.copyProperties(userDto,user);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
