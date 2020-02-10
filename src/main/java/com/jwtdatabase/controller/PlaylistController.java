package com.jwtdatabase.controller;

import com.jwtdatabase.model.DAOPlaylist;
import com.jwtdatabase.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/playlist")
    public long createPlaylist(@RequestBody DAOPlaylist playlist){
        return playlistService.createPlaylist(playlist.getPlaylistTitle(),playlist.getDescription());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/playlist/{id}/{track_id}")
    public boolean addPlaylist(@PathVariable long id, @PathVariable String track_id){
        return playlistService.addToPlaylist(id,track_id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/playlist/{id}")
    public boolean removePlaylist(@PathVariable long id){
        return playlistService.deletePlaylist(id);
    }
}
