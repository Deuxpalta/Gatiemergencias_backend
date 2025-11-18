package com.example.gatiemergencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gatiemergencias.model.Role;
import com.example.gatiemergencias.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Idk, emergency system or smt")
public class RoleController {

    @Autowired
    private RoleService rolService;

    @GetMapping
    @Operation(summary = "View a list of available roles")
    public List<Role> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a role by Id")
    public Role getRoleById(@PathVariable Long id) {
        return rolService.getRoleById(id);
    }

    @PostMapping
    @Operation(summary = "Add a new role")
    public Role createRole(@RequestBody Role role) {
        return rolService.saveRole(role);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing role")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        Role existingRole = rolService.getRoleById(id);
        if (existingRole != null) {
            existingRole.setNombre(role.getNombre());
            return rolService.saveRole(existingRole);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a role")
    public void deleteRole(@PathVariable Long id) {
        rolService.deleteRole(id);
    }
}
