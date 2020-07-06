package com.jwtdatabase.controller;

import com.jwtdatabase.model.DAOTrack;
import com.jwtdatabase.service.DeezerAPIEndpoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    private final DeezerAPIEndpoints deezerAPIEndpoints = new DeezerAPIEndpoints();


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String search(@RequestParam String q){

        try {
            return deezerAPIEndpoints.search(q);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "No Results";
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/search_albums", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findAlbums(@RequestParam String q){

        try {
            return deezerAPIEndpoints.findAlbums(q);
        } catch( Exception e){
            e.printStackTrace();
        }
        return "No results";
    }



}
