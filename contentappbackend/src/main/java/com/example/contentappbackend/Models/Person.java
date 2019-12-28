package com.example.contentappbackend.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", unique = true, nullable = false)
    private Long personId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(joinColumns = @JoinColumn(name = "personId", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER, cascade =
            {CascadeType.REMOVE,CascadeType.REFRESH},orphanRemoval = true)
    private Set<Content> contents;

    @OneToMany(mappedBy = "admin",cascade =
            {CascadeType.REMOVE})
    private Set<Person> persons;
    @ManyToOne()
    @JoinColumn(name="admin_id")
    private Person admin;

    public Person(){

    }
    public Person(Person person) {
        this.personId = person.getPersonId();
        this.password = person.getPassword();
        this.username = person.getUsername();
        this.roles = person.getRoles();
        this.persons = person.getPersons();
        this.contents = person.getContents();

    }




    public void setAdmin(Person admin) {
        this.admin = admin;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
