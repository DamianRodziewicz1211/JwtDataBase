package com.jwtdatabase.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "track")
public class DAOTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trackId;
    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private String album;
    @Column
    private Integer duration;

    public DAOTrack(String title, String artist, String album, Integer duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public DAOTrack() {
    }

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

    public long getTrackId() {
        return trackId;
    }

    @Override
    public String toString() {
        return "DAOTrack{" +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", duration=" + duration +
                '}';
    }
}
