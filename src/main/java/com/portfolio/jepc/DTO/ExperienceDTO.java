
package com.portfolio.jepc.DTO;

import jakarta.validation.constraints.NotBlank;


public class ExperienceDTO {
    @NotBlank
    private String expName;
    @NotBlank
    private String expDescription;
    private String expImgUrl;
    
    //Constructor

    public ExperienceDTO() {
    }

    public ExperienceDTO(String expName, String expDescription, String expImgUrl) {
        this.expName = expName;
        this.expDescription = expDescription;
        this.expImgUrl = expImgUrl;
    }

    //Getters&Setters

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpDescription() {
        return expDescription;
    }

    public void setExpDescription(String expDescription) {
        this.expDescription = expDescription;
    }

    public String getExpImgUrl() {
        return expImgUrl;
    }

    public void setExpImgUrl(String expImgUrl) {
        this.expImgUrl = expImgUrl;
    }
    
}
