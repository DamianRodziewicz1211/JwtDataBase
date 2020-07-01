package com.jwtdatabase.controller;

import com.jwtdatabase.model.DAOAlbum;
import com.jwtdatabase.model.ResponseId;
import com.jwtdatabase.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/album", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DAOAlbum> getAlbums(){
        return albumService.printAlbums();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/album/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchAlbum(@PathVariable (value = "id") Integer id){
        return albumService.getAlbum(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/album")
    public String addAlbum(@RequestBody ResponseId id){
        return albumService.addAlbum(id.getId());
    }

    @ResponseStatus(value = HttpStatus.GONE)
    @DeleteMapping(value = "/album/{id}")
    public boolean removeAlbum(@PathVariable long id){
        return albumService.deleteAlbum(id);
    }
}
