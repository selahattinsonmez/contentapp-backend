package com.example.contentappbackend.Service;

import com.example.contentappbackend.Models.Person;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Person findUserByUsername(String username);
    void deleteUserByUsername(String username);
    boolean deleteContentById(Long content_id);
}
