
package com.portfolio.jepc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expName;
    private String expDescription;
    private String expImgUrl;
    
    //Constructor
    public Experience() {
    }

    public Experience(String expName, String expDescription, String expImgUrl) {
        this.expName = expName;
        this.expDescription = expDescription;
        this.expImgUrl = expImgUrl;
    }

    
    
    //Getters&Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
