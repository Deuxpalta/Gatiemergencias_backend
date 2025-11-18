package com.example.gatiemergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gatiemergencias.model.Emergency;
import com.example.gatiemergencias.repository.EmergencyRepository;
import java.util.List;

@Service
public class EmergencyService {
    @Autowired
    private EmergencyRepository emergencyRepository;

    public List<Emergency> getAllEmergencies() {
        return emergencyRepository.findAll();
    }

    public Emergency getEmergencyById(Long id) {
        return emergencyRepository.findById(id).orElse(null);
    }

    public Emergency saveEmergency(Emergency emergency) {
        return emergencyRepository.save(emergency);
    }

    public void deleteEmergency(Long id) {
        emergencyRepository.deleteById(id);
    }
}