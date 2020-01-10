package com.jwtdatabase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String HelloAlbums() { return "Hello from albums";}
}
