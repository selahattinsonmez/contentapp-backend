package com.example.contentappbackend.Controller;

import com.example.contentappbackend.Models.Person;
import com.example.contentappbackend.Models.isDeletedDTO;
import com.example.contentappbackend.Service.AdminService;
import com.example.contentappbackend.Service.AdminServiceImp;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;

@RestController
@RequestMapping("/Admin")
public class AdminController {



    @Autowired
    AdminServiceImp adminService;
    @Autowired
    isDeletedDTO isDeletedDTO;

    @GetMapping("/Home")
    public Person home(Principal principal){
        return adminService.findUserByUsername(principal.getName());
    }

    @Transactional
    @DeleteMapping("/deleteUserByUserName/{username}")
    public void deleteUserByUserName(@PathVariable String username){
        adminService.deleteUserByUsername(username);
    }

    @Transactional
    @DeleteMapping("/deleteContentByID/{content_id}")
    public isDeletedDTO deleteContentById(@PathVariable Long content_id){
        isDeletedDTO.setDeleted(adminService.deleteContentById(content_id));
        return isDeletedDTO;
    }

}
