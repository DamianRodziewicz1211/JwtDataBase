
package com.jwtdatabase.model;

import javax.persistence.*;
import java.util.*;

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

    @ElementCollection
    @MapKeyColumn(name = "track_nr")
    @Column(name = "title")
    @CollectionTable(name = "Track_list")
    private Map<String,String> tracks = new HashMap<String,String>();

    @Column
    private String genre;

    @Column
    private String cover;

    @Column
    private Integer deezerId;

    public DAOAlbum() {
    }

    public DAOAlbum(String title, String artist, Map<String, String> tracks, String genre, String cover, Integer deezerId) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.genre = genre;
        this.cover = cover;
        this.deezerId = deezerId;
    }

    public long getAlbumId() {
        return albumId;
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

    public Map<String, String> getTracks() {
        return tracks;
    }

    public void setTracks(Map<String, String> tracks) {
        this.tracks = tracks;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        return "DAOAlbum{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", genre='" + genre + '\'' +
                ", cover='" + cover + '\'' +
                ", deezerId=" + deezerId +
                '}';
    }
}
