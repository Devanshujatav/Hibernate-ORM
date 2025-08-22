package com.devanshu;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;

    @OneToMany(fetch = FetchType.EAGER)
    Collection<Laptop> laps = new ArrayList<>();

    public Collection<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop> laps) {
        this.laps = laps;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
