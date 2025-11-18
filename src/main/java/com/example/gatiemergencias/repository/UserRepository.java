package com.example.gatiemergencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gatiemergencias.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
