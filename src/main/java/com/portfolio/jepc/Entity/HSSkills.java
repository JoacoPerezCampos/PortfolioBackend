
package com.portfolio.jepc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HSSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hsName;
    private int percent;
    
    //Constructor

    public HSSkills() {
    }

    public HSSkills(String hsName, int percent) {
        this.hsName = hsName;
        this.percent = percent;
    }
    
    //Getters&Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

