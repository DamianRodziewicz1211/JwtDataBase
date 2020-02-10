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
    private Map<Integer,String> tracks = new HashMap<Integer,String>();

    @Column
    private String genre;

    public DAOAlbum() {
    }

    public DAOAlbum(String title, String artist, Map<Integer, String> tracks, String genre) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.genre = genre;
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

    public Map<Integer, String> getTracks() {
        return tracks;
    }

    public void setTracks(Map<Integer, String> tracks) {
        this.tracks = tracks;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return '{' +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", genre='" + genre + '\'' +
                '}';
    }
}
