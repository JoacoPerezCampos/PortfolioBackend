package com.portfolio.jepc.DTO;

import jakarta.validation.constraints.NotBlank;

public class ProyectDTO {

    @NotBlank
    private String pName;
    @NotBlank
    private String pDescription;
    private String pImg1Url;
    private String pImg2Url;
    private String pImg3Url;
    private String pImg4Url;

    //Constructor
    public ProyectDTO() {
    }

    public ProyectDTO(String pName, String pDescription, String pImg1Url, String pImg2Url, String pImg3Url, String pImg4Url) {
        this.pName = pName;
        this.pDescription = pDescription;
        this.pImg1Url = pImg1Url;
        this.pImg2Url = pImg2Url;
        this.pImg3Url = pImg3Url;
        this.pImg4Url = pImg4Url;
    }

    //Getters&Setters
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpImg1Url() {
        return pImg1Url;
    }

    public void setpImg1Url(String pImg1Url) {
        this.pImg1Url = pImg1Url;
    }

    public String getpImg2Url() {
        return pImg2Url;
    }

    public void setpImg2Url(String pImg2Url) {
        this.pImg2Url = pImg2Url;
    }

    public String getpImg3Url() {
        return pImg3Url;
    }

    public void setpImg3Url(String pImg3Url) {
        this.pImg3Url = pImg3Url;
    }

    public String getpImg4Url() {
        return pImg4Url;
    }

    public void setpImg4Url(String pImg4Url) {
        this.pImg4Url = pImg4Url;
    }

}
