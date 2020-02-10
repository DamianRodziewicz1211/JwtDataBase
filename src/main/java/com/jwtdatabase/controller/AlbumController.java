package com.jwtdatabase.controller;

import com.jwtdatabase.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String HelloAlbum(){
        return "Hello from album";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/album/{id}")
    public String searchAlbum(@PathVariable String id){

        return albumService.getAlbum(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/album/{id}")
    public long addAlbum(@PathVariable String id){
        return albumService.addAlbum(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/album/{id}")
    public boolean removeAlbum(@PathVariable long id){
        return albumService.deleteAlbum(id);
    }
}
