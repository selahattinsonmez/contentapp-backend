package com.example.contentappbackend.Repository;

import com.example.contentappbackend.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
