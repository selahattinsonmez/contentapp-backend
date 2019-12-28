package com.example.contentappbackend.Service;

import com.example.contentappbackend.Models.Person;
import com.example.contentappbackend.Models.UserDetails2;
import com.example.contentappbackend.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsService2 implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<Person> optionalPerson = personRepository.findFirstByUsername(username);
         optionalPerson
                 .orElseThrow(()->new UsernameNotFoundException("Username not found."));
         return optionalPerson
                 .map(UserDetails2::new).get();

    }
}
