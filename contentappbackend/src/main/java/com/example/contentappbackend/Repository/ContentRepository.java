package com.example.contentappbackend.Repository;

import com.example.contentappbackend.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {
    Content deleteByTitle(String title);



}
