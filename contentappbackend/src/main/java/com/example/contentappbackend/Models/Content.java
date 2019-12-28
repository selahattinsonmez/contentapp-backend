package com.example.contentappbackend.Models;

import javax.persistence.*;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "content_id")
    private Long content_id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "image")
    private String image;
    @Column(name = "person_id")
    private Long person_id;
    @ManyToOne
    @JoinColumn(name="person_id",insertable = false,updatable = false)
    private Person person;

    public Content(){

    }
    public Content(Content content){
        this.content_id = content.getContent_id();
        this.image = content.getImage();
        this.text = content.getText();
        this.title = content.getTitle();
        this.person_id = content.getPerson_id();
    }


    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }





    public Long getContent_id() {
        return content_id;
    }

    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
