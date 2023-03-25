package com.portfolio.jepc.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class HSSkillsDTO {

    @NotBlank
    private String hsName;
    @NotBlank
    private int percent;

    //Constructor
    public HSSkillsDTO() {
    }

    public HSSkillsDTO(String hsName, int percent) {
        this.hsName = hsName;
        this.percent = percent;
    }

    //Getters&Setters
    public String getHsName() {
        return hsName;
    }

    public void setHsName(String hsName) {
        this.hsName = hsName;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

}
