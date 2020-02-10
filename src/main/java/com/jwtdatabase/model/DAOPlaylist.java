package com.jwtdatabase.model;


import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ElementCollection
    @MapKeyColumn(name = "track_nr")
    @Column(name = "title")
    @CollectionTable(name = "Playlist_tracks")
    private Map<Integer,String> playlistTracks;

    public DAOPlaylist() {
    }

    public DAOPlaylist(String playlistTitle, String description) {
        this.playlistTitle = playlistTitle;
        this.description = description;
        this.playlistTracks = new HashMap<>();
    }

    public long getPlaylistId() {
        return playlistId;
    }

    public Map<Integer, String> getPlaylistTracks() {
        return playlistTracks;
    }

    public void setPlaylistTracks(Map<Integer, String> playlistTracks) {
        this.playlistTracks = playlistTracks;
    }

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

    @Override
    public String toString() {
        return '{' +
                "playlistTitle='" + playlistTitle + '\'' +
                ", description='" + description + '\'' +
                ", playlistTracks=" + playlistTracks +
                '}';
    }
}
