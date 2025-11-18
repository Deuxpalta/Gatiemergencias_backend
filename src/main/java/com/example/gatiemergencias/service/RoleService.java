package com.example.gatiemergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gatiemergencias.model.Role;
import com.example.gatiemergencias.repository.RoleRepository;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository rolRepository;

    public List<Role> getAllRoles() {
        return rolRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Role saveRole(Role role) {
        return rolRepository.save(role);
    }

    public void deleteRole(Long id) {
        rolRepository.deleteById(id);
    }
}
