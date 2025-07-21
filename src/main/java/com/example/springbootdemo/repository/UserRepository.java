package com.example.springbootdemo.repository;

import com.example.springbootdemo.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository    // Spring's Bean
public interface UserRepository extends CrudRepository<User,Integer> {

}
