package com.portfolio.jepc.DTO;

import jakarta.validation.constraints.NotBlank;

public class PersonDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String profileImgUrl;
    @NotBlank
    private String about;

    //Constructor
    public PersonDTO() {
    }

    public PersonDTO(String name, String lastname, String profileImgUrl, String about) {
        this.name = name;
        this.lastname = lastname;
        this.profileImgUrl = profileImgUrl;
        this.about = about;
    }
    
    //Getters&Setters

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
