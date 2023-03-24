
package com.portfolio.jepc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String edName;
    private String edDescription;
    private String edImgUrl;
    
    //Constructor

    public Education() {
    }

    public Education(String edName, String edDescription, String edImgUrl) {
        this.edName = edName;
        this.edDescription = edDescription;
        this.edImgUrl = edImgUrl;
    }
    
    //Getters&Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
