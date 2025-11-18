package com.example.gatiemergencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gatiemergencias.model.EmergencyType;

public interface EmergencyTypeRepository extends JpaRepository<EmergencyType, Long> {
}
