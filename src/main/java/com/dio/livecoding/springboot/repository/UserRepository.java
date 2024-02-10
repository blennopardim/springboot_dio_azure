package com.dio.livecoding.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.dio.livecoding.springboot.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{

    
}