package com.library_DM.DeathMetal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BANDS")
public class BandEntity {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String country;
    private String status;
    @JsonIgnore
    private Long formed_in;
    private String genre;
    private String theme;
    private String active;

    @OneToMany(mappedBy = "band")
    private List<AlbumEntity> albums;

    public BandEntity(){}

    public BandEntity(long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<AlbumEntity> getAlbums() {
        return albums;
    }


}