package com.example.contentappbackend.Models;

import org.springframework.stereotype.Component;

@Component
public class RoleDTO {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
