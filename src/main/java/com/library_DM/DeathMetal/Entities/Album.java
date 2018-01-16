package com.library_DM.DeathMetal.Entities;


import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue

    private long id;

    @ManyToOne
    @JoinColumn(name = "band")
    private Band band;

    private  String title;

    private long year;

    public Album(Band band, String title, long year) {
        this.band = band;
        this.title = title;
        this.year = year;
    }

    public Album() {
    }

    public long getId() {
        return id;
    }

    public Band getBand() {
        return band;
    }

    public String getTitle() {
        return title;
    }

    public long getYear() {
        return year;
    }
}
