package com.example.contentappbackend.Controller;

import com.example.contentappbackend.Models.Content;
import com.example.contentappbackend.Models.Person;
import com.example.contentappbackend.Models.UserDetails2;
import com.example.contentappbackend.Models.isDeletedDTO;
import com.example.contentappbackend.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    public UserServiceImp userService;
    @Autowired
    isDeletedDTO isDeletedDTO;
    @GetMapping("/Home")
    public Person home(){


        return userService.findUserByUsername(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
    @Transactional
    @DeleteMapping("/deleteContentByID/{content_id}")
    public isDeletedDTO deleteContentById(@PathVariable Long content_id){

        isDeletedDTO.setDeleted(userService.deleteContentById(content_id));
        return isDeletedDTO;
    }

    @PutMapping("/createContent")
    public void createContent(@RequestBody Content content){

        content.setPerson_id(((UserDetails2)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPerson_id());
        userService.createContent(content);
    }
}
