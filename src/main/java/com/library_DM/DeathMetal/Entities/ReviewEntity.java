package com.library_DM.DeathMetal.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "REVIEWES")
public class ReviewEntity {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "ALBUM")
    @JsonManagedReference
    private AlbumEntity album;

    private String title;

    private long score;

    private String continent;

    private String content;

    public ReviewEntity() {
    }

    public ReviewEntity(long id, AlbumEntity album, String title, long score) {
        this.id = id;
        this.album = album;
        this.title = title;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    public long getScore() {
        return score;
    }

    public String getContinent() {
        return continent;
    }

    public String getContent() {
        return content;
    }
}
