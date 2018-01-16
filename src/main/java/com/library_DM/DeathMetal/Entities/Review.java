package com.library_DM.DeathMetal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    private  long id;

    @ManyToOne
    @JoinColumn(name ="album")
    private Album album;

    private String title;

    private double score;

    private String countent;

    public Review(Album album, String title, double score, String countent) {
        this.album = album;
        this.title = title;
        this.score = score;
        this.countent = countent;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public String getCountent() {
        return countent;
    }
}
