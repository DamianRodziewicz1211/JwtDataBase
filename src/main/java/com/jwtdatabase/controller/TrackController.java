package com.jwtdatabase.controller;


import com.jwtdatabase.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;



    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public String HelloTracks(){
        return "Hello from tracks";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/track/{id}")
    public String searchTrack(@PathVariable String id){

        return trackService.getTrack(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/track/{id}")
    public long addTrack(@PathVariable String id){
        return trackService.addTrack(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(value = "/track/{id}")
    public boolean removeTrack(@PathVariable long id){
        return trackService.deleteTrack(id);
    }
}
