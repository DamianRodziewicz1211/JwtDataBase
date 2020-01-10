package com.jwtdatabase.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavouriteController {


    @RequestMapping(value = "/favourite", method = RequestMethod.GET)
    public String HelloFavourite(){ return "Hello form favourite";}
}
