package com.jwtdatabase.model;

import javax.persistence.*;

@Entity
@Table(name = "favourite")
public class DAOFavourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favouriteId;
    @Column
    private Integer[] tracks;
    @Column
    private Integer[] artists;
    @Column
    private Integer[] albums;
    @Column
    private Integer[] playlists;

    public Integer[] getTracks() {
        return tracks;
    }

    public void setTracks(Integer[] tracks) {
        this.tracks = tracks;
    }

    public Integer[] getArtists() {
        return artists;
    }

    public void setArtists(Integer[] artists) {
        this.artists = artists;
    }

    public Integer[] getAlbums() {
        return albums;
    }

    public void setAlbums(Integer[] albums) {
        this.albums = albums;
    }

    public Integer[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Integer[] playlists) {
        this.playlists = playlists;
    }
}
