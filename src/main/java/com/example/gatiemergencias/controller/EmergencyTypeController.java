package com.example.gatiemergencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gatiemergencias.model.EmergencyType;
import com.example.gatiemergencias.service.EmergencyTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/emergency-types")
@Tag(name = "Idk, emergency system or smt")
public class EmergencyTypeController {

    @Autowired
    private EmergencyTypeService emergencyTypeService;

    @GetMapping
    @Operation(summary = "View a list of available emergencies types")
    public List<EmergencyType> getAllEmergencyTypes() {
        return emergencyTypeService.getAllEmergencyTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an emergency type by Id")
    public EmergencyType getEmergencyTypeById(@PathVariable Long id) {
        return emergencyTypeService.getEmergencyTypeById(id);
    }

    @PostMapping
    @Operation(summary = "Add a new emergency type")
    public EmergencyType createEmergencyType(@RequestBody EmergencyType emergencyType) {
        return emergencyTypeService.saveEmergencyType(emergencyType);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing emergency type")
    public EmergencyType updateEmergencyType(@PathVariable Long id, @RequestBody EmergencyType emergencyType) {
        EmergencyType existingEmergencyType = emergencyTypeService.getEmergencyTypeById(id);
        if (existingEmergencyType != null) {
            existingEmergencyType.setName(emergencyType.getName());
            return emergencyTypeService.saveEmergencyType(existingEmergencyType);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an emergency type")
    public void deleteEmergencyType(@PathVariable Long id) {
        emergencyTypeService.deleteEmergencyType(id);
    }
}
