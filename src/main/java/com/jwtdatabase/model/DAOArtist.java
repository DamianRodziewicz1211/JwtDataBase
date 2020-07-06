package com.jwtdatabase.model;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class DAOArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistId;
    @Column
    private String artistName;
    @Column
    private Integer numberOfAlbums;
    @Column
    private Integer numberOfFans;
    @Column
    private String type;



    public DAOArtist() {
    }

    public DAOArtist(String artistName, Integer numberOfAlbums, Integer numberOfFans, String type) {
        this.artistName = artistName;
        this.numberOfAlbums = numberOfAlbums;
        this.numberOfFans = numberOfFans;
        this.type = type;
    }

    public long getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Integer getNumberOfAlbums() {
        return numberOfAlbums;
    }

    public void setNumberOfAlbums(Integer numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    public Integer getNumberOfFans() {
        return numberOfFans;
    }

    public void setNumberOfFans(Integer numberOfFans) {
        this.numberOfFans = numberOfFans;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return '{' +
                "artistName='" + artistName + '\'' +
                ", numberOfAlbums=" + numberOfAlbums +
                ", numberOfFans=" + numberOfFans +
                ", type='" + type + '\'' +
                '}';
    }
}
