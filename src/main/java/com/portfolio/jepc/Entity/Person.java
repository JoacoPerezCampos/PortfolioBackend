package com.portfolio.jepc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "Debe tener entre 3 y 50 caracteres")
    private String name;

    @NotNull
    @Size(min = 3, max = 50, message = "Debe tener entre 3 y 50 caracteres")
    private String lastname;

    private String profileImgUrl;
    
    @NotNull
    private String about;
    
    //Contructor

    public Person() {
    }

    public Person(String name, String lastname, String profileImgUrl, String about) {
        this.name = name;
        this.lastname = lastname;
        this.profileImgUrl = profileImgUrl;
        this.about = about;
    }
    

    /**Getters & Setters**/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}
