package com.jwtdatabase.controller;


import com.jwtdatabase.model.DAOTrack;
import com.jwtdatabase.model.ResponseId;
import com.jwtdatabase.service.TrackService;
import org.apache.http.MethodNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/track",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DAOTrack> printTracks(){

        return trackService.printTracks();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(value = "/track/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchTrack(@PathVariable (value = "id") Integer id){

        return trackService.getTrack(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/track",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public String addTrack(@RequestBody ResponseId id ){
        return trackService.addTrack(id.getId());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(value = HttpStatus.GONE)
    @DeleteMapping(value = "/track/{id}")
    public boolean removeTrack(@PathVariable long id){
        return trackService.deleteTrack(id);
    }
}
