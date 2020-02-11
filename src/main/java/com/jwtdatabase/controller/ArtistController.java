package com.jwtdatabase.controller;

import com.jwtdatabase.model.ResponseId;
import com.jwtdatabase.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public String helloArtist(){
        return "Hello from artist";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/artist/{id}")
    public String searchArtist(@PathVariable Integer id){
        return artistService.getArtist(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/artist")
    public String addArtist(@RequestBody ResponseId id){

        return artistService.addArtist(id.getId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/artist/{id}")
    public boolean removeArtist(@PathVariable long id){
        return artistService.deleteArtist(id);
    }
}
