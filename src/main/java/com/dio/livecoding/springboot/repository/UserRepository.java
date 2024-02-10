package com.dio.livecoding.springboot.repository;

import com.dio.livecoding.springboot.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{

    
}