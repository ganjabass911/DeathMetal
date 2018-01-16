package com.library_DM.DeathMetal.Entities;



import javax.persistence.*;

@Entity
@Table(name = "bands")
public class Band {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String country;

    private String status;

    private  long formed_in;

    private String genre;

    private String theme;

    private String active;

    public Band(String name, String country, String status, long formed_in, String genre, String theme, String active) {
        this.name = name;
        this.country = country;
        this.status = status;
        this.formed_in = formed_in;
        this.genre = genre;
        this.theme = theme;
        this.active = active;
    }

    public Band() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getStatus() {
        return status;
    }

    public long getFormed_in() {
        return formed_in;
    }

    public String getGenre() {
        return genre;
    }

    public String getTheme() {
        return theme;
    }

    public String getActive() {
        return active;
    }
}
