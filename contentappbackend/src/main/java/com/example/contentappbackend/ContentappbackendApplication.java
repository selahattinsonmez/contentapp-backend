package com.example.contentappbackend;

import com.example.contentappbackend.Models.isDeletedDTO;
import com.example.contentappbackend.Repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public class ContentappbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentappbackendApplication.class, args);
    }


}
