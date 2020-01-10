package com.jwtdatabase.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String HelloArtist(){ return "Hello from artists";}
}
