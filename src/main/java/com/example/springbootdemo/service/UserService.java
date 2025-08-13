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
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("用户不存在，参数异常！"));
    }

    @Override
    public User edit(Integer id, UserDto userDto) {
        // ✔ 使用 CrudRepository 的 findById 方法
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        // ✔ 更新字段
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        // ✔ save 仍然使用原始接口方法
        return userRepository.save(user);
    }



    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
