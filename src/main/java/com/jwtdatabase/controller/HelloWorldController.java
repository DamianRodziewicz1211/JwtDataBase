package com.jwtdatabase.controller;

import com.jwtdatabase.service.DeezerAPIEndpoints;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    private final DeezerAPIEndpoints dc = new DeezerAPIEndpoints();

    @RequestMapping({ "/hello"})
    public String firstPage() {
            return "Hello World";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/search")
    public String search(@RequestParam String q){

        try {
            return dc.search(q);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Something missing";
    }



    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/artist/{id}")
    public String searchArtist(@PathVariable String id){
        try{
            return dc.searchArtist(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Something missing";
    }



    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/playlist/{id}")
    public String searchPlaylist(@PathVariable String id){
        try{
            return dc.searchPlaylist(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Something missing";
    }
}
