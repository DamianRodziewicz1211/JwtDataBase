package com.jwtdatabase.controller;

import com.jwtdatabase.model.DAOPlaylist;
import com.jwtdatabase.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/playlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DAOPlaylist> printPlaylists() {
        return playlistService.printPlaylists();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/playlist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPlaylist(@PathVariable long id){
        return playlistService.getPlaylist(id);
    }


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/playlist")
    public long createPlaylist(@RequestBody DAOPlaylist playlist){
        return playlistService.createPlaylist(playlist.getPlaylistTitle(),playlist.getDescription());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/playlist/{id}/{track_id}")
    public String addPlaylist(@PathVariable long id, @PathVariable Integer track_id){
        return playlistService.addToPlaylist(id,track_id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/playlist/{id}")
    public boolean removePlaylist(@PathVariable long id){
        return playlistService.deletePlaylist(id);
    }
}
