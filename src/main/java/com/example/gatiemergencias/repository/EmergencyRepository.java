package com.example.gatiemergencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gatiemergencias.model.Emergency;

public interface EmergencyRepository extends JpaRepository<Emergency, Long> {
}
