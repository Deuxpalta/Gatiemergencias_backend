package com.example.gatiemergencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gatiemergencias.model.Emergency;
import com.example.gatiemergencias.service.EmergencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/emergencies")
@Tag(name = "Idk, emergency system or smt")
public class EmergencyController {

    @Autowired
    private EmergencyService emergencyService;

    @GetMapping
    @Operation(summary = "View a list of available emergencies")
    public List<Emergency> getAllEmergencies() {
        return emergencyService.getAllEmergencies();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an emergency by Id")
    public Emergency getEmergencyById(@PathVariable Long id) {
        return emergencyService.getEmergencyById(id);
    }

    @PostMapping
    @Operation(summary = "Add a new emergency")
    public Emergency createEmergency(@RequestBody Emergency emergency) {
        return emergencyService.saveEmergency(emergency);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing emergency")
    public Emergency updateEmergency(@PathVariable Long id, @RequestBody Emergency emergency) {
        Emergency existingEmergency = emergencyService.getEmergencyById(id);
        if (existingEmergency != null) {
            existingEmergency.setDescription(emergency.getDescription());
            existingEmergency.setLocation(emergency.getLocation());
            return emergencyService.saveEmergency(existingEmergency);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an emergency")
    public void deleteEmergency(@PathVariable Long id) {
        emergencyService.deleteEmergency(id);
    }
}
