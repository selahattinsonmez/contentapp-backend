package com.example.contentappbackend.Controller;

import com.example.contentappbackend.Models.Role;
import com.example.contentappbackend.Models.RoleDTO;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.text.normalizer.ICUBinary;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {
    @Autowired
    RoleDTO roleDTO;
    @GetMapping(value = "")
    public RoleDTO authenticate(){
        setRole();
        return roleDTO;

    }
    void setRole(){
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        role = role.substring(1,role.length()-1);
        roleDTO.setRole(role);

    }
}
