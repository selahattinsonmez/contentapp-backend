package com.example.contentappbackend.Service;

import com.example.contentappbackend.Models.Content;
import com.example.contentappbackend.Models.Person;
import com.example.contentappbackend.Repository.ContentRepository;
import com.example.contentappbackend.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    ContentRepository contentRepository;
    public Person findUserByUsername(String username){
        return personRepository.findFirstByUsername(username).map(Person::new).get();
    }
    public void deleteUserByUsername(String username){
        personRepository.deleteByUsername(username);
    }
    public boolean deleteContentById(Long content_id){
        Long person_id = contentRepository.findById(content_id).map(Content::new).get().getPerson_id();
        contentRepository.deleteById(content_id);
        return deleteUserIfContentsEmpty(person_id);
    }

    public boolean deleteUserIfContentsEmpty(Long person_id){

        Person person = personRepository.findById(person_id).map(Person::new).get();
        if(person.getContents().size()<=1){
            personRepository.delete(person);
            return false;
        }
        return true;
    }
}
