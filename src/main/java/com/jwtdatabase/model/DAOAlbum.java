package com.jwtdatabase.model;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class DAOAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;
    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private Integer[] tracks;
    @Column
    private Integer rate;

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

    public Integer[] getTracks() {
        return tracks;
    }

    public void setTracks(Integer[] tracks) {
        this.tracks = tracks;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
