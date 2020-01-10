package com.jwtdatabase.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "track")
public class DAOTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trackId;
    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private String album;
    @Column
    private Integer duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
