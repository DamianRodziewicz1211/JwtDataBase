package com.jwtdatabase.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackController {


    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public String HelloTracks(){
        return "Hello from tracks";
    }
}
