package com.example.contentappbackend.Service;

import com.example.contentappbackend.Models.Content;
import com.example.contentappbackend.Models.Person;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Person findUserByUsername(String username);
    boolean deleteContentById(Long content_id);
    void createContent(Content content);
}
