package com.example.contentappbackend.Repository;

import com.example.contentappbackend.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findFirstByUsername(String username);
    void deleteByUsername(String username);
}
