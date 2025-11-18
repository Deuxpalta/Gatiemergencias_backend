package com.example.gatiemergencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gatiemergencias.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
