package com.example.contentappbackend.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetails2 extends Person implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private Long person_id;
    public UserDetails2(final Person person){
        this.person_id = person.getPersonId();
       this.username = person.getUsername();
       this.password = person.getPassword();
       this.authorities = person.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRoleName()))
                .collect(Collectors.toList());;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }
    public Long getPerson_id(){
        return person_id;
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
