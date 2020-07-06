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
    @Column
    private String preview;
    @Column
    private String cover;
    @Column
    private Integer deezerId;


    public DAOTrack(String title, String artist, String album, Integer duration, String preview,String cover,Integer deezerId) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.preview = preview;
        this.cover = cover;
        this.deezerId = deezerId;
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

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDeezerId() {
        return deezerId;
    }

    public void setDeezerId(Integer deezerId) {
        this.deezerId = deezerId;
    }


    @Override
    public String toString() {
        return "DAOTrack{" +
                "trackId=" + trackId +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", duration=" + duration +
                ", preview='" + preview + '\'' +
                ", cover='" + cover + '\'' +
                ", deezerId=" + deezerId +
                '}';
    }
}
