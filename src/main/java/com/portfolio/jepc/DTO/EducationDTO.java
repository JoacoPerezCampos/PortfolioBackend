package com.portfolio.jepc.DTO;

import jakarta.validation.constraints.NotBlank;


public class EducationDTO {
    @NotBlank
    private String edName;
    @NotBlank
    private String edDescription;
    private String edImgUrl;
    
    //Contructor

    public EducationDTO() {
    }

    public EducationDTO(String edName, String edDescription, String edImgUrl) {
        this.edName = edName;
        this.edDescription = edDescription;
        this.edImgUrl = edImgUrl;
    }
    
    //Getters&Setters

    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public String getEdDescription() {
        return edDescription;
    }

    public void setEdDescription(String edDescription) {
        this.edDescription = edDescription;
    }

    public String getEdImgUrl() {
        return edImgUrl;
    }

    public void setEdImgUrl(String edImgUrl) {
        this.edImgUrl = edImgUrl;
    }
    
}
