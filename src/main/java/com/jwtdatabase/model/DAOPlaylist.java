package com.jwtdatabase.model;


import javax.persistence.*;

@Entity
@Table(name="playlist")
public class DAOPlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playlistId;
    @Column
    private String playlistTitle;
    @Column
    private String description;

    public String getPlaylistTitle() {
        return playlistTitle;
    }

    public void setPlaylistTitle(String playlistTitle) {
        this.playlistTitle = playlistTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
