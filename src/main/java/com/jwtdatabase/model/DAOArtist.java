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



    public String getName() {
        return artistName;
    }

    public void setName(String name) {
        this.artistName = name;
    }

    public Integer getNb_albums() {
        return numberOfAlbums;
    }

    public void setNb_albums(Integer nb_albums) {
        this.numberOfAlbums = nb_albums;
    }
}
