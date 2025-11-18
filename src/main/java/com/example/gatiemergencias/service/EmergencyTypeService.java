package com.example.gatiemergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gatiemergencias.model.EmergencyType;
import com.example.gatiemergencias.repository.EmergencyTypeRepository;
import java.util.List;

@Service
public class EmergencyTypeService {
    @Autowired
    private EmergencyTypeRepository emergencyTypeRepository;

    public List<EmergencyType> getAllEmergencyTypes() {
        return emergencyTypeRepository.findAll();
    }

    public EmergencyType getEmergencyTypeById(Long id) {
        return emergencyTypeRepository.findById(id).orElse(null);
    }

    public EmergencyType saveEmergencyType(EmergencyType emergencyType) {
        return emergencyTypeRepository.save(emergencyType);
    }

    public void deleteEmergencyType(Long id) {
        emergencyTypeRepository.deleteById(id);
    }
}
