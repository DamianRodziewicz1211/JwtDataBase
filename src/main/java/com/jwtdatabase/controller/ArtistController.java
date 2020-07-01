package com.jwtdatabase.controller;

import com.jwtdatabase.model.DAOArtist;
import com.jwtdatabase.model.ResponseId;
import com.jwtdatabase.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/artist", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DAOArtist> getArtist(){
        return artistService.printArtists();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/artist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchArtist(@PathVariable Integer id){
        return artistService.getArtist(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/artist")
    public String addArtist(@RequestBody ResponseId id){

        return artistService.addArtist(id.getId());
    }

    @ResponseStatus(value = HttpStatus.GONE)
    @DeleteMapping(value = "/artist/{id}")
    public boolean removeArtist(@PathVariable long id){
        return artistService.deleteArtist(id);
    }
}
