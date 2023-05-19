package com.khube.spring.security.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khube.spring.security.main.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
