package com.example.contentappbackend.Service;

import com.example.contentappbackend.Models.Content;
import com.example.contentappbackend.Models.Person;
import com.example.contentappbackend.Repository.ContentRepository;
import com.example.contentappbackend.Repository.PersonRepository;
import org.apache.catalina.Session;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ContentRepository contentRepository;

    @Override
    public Person findUserByUsername(String username){
        return personRepository.findFirstByUsername(username).map(Person::new).get();
    }
    @Override
    public boolean deleteContentById(Long content_id){
        Long person_id = contentRepository.findById(content_id).map(Content::new).get().getPerson_id();
        contentRepository.deleteById(content_id);


        return deleteUserIfContentsEmpty(person_id);
    }
    @Override
    public void createContent(Content content){
        contentRepository.save(content);
    }

    public boolean deleteUserIfContentsEmpty(Long person_id){

        Person person = personRepository.findById(person_id).map(Person::new).get();
        if(person.getContents().size()<=1){//kayıt buradan sonra siliniyor
            personRepository.delete(person);
            return false;
        }
        return true;
    }
}
