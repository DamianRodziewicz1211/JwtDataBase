package com.jwtdatabase.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import com.jwtdatabase.model.*;
import com.jwtdatabase.repository.UserDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.hibernate.exception.DataException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MissingServletRequestParameterException;


import javax.websocket.EncodeException;
import java.net.URLEncoder;
import java.util.*;


public class DeezerAPIEndpoints {

    @Autowired
    private UserDao userRepo;

    private String rapidapiHost = "deezerdevs-deezer.p.rapidapi.com";

    private String rapidapiKey = "6c7906ce15msh5277a249c6b8a50p15dbecjsn396b42a7eec8";

    public String search( String q) throws Exception {

        //host
        String host = "https://api.deezer.com/search";
        String charset = "UTF-8";

        //rapidapi
        String rapidapiHost = "deezerdevs-deezer.p.rapidapi.com";
        String rapidapiKey = "6c7906ce15msh5277a249c6b8a50p15dbecjsn396b42a7eec8";
        String query = String.format(("q=%s"), URLEncoder.encode(q,charset));

        HttpResponse<String> response = Unirest.get(host + "?" + query)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asString();


        return response.getBody();

    }

    public DAOAlbum searchAlbum (String id) throws Exception {

        String host = "https://api.deezer.com/album/";
        String charset = "UTF-8";


        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();



        Map<Integer,String> listOfTracks = new HashMap<>();

        JSONObject json = new JSONObject(response.getBody().toString());
        JSONArray trackList = json.getJSONObject("tracks").getJSONArray("data");
        JSONObject genre = json.getJSONObject("genres").getJSONArray("data").getJSONObject(0);

        for(int i=0;i<trackList.length();i++){
            JSONObject track = trackList.getJSONObject(i);
            listOfTracks.put(i,track.getString("title"));
        }

        DAOAlbum album = new DAOAlbum(
                json.getString("title"),
                json.getJSONObject("artist").getString("name"),
                listOfTracks,
                genre.getString("name")
        );

        return album;


    }

    public DAOArtist searchArtist(String id) throws Exception{

        String host = "https://api.deezer.com/artist/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        JSONObject json = new JSONObject(response.getBody().toString());

        DAOArtist newArtist = new DAOArtist(
                json.getString("name"),
                json.getInt("nb_album"),
                json.getInt("nb_fan"),
                json.getString("type")
        );

        return newArtist;
    }

    public DAOTrack searchTrack(String id) throws Exception{

        String host = "https://api.deezer.com/track/";
        String charset = "UTF-8";
        ObjectMapper objectMapper = new ObjectMapper();

        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        JSONObject json = new JSONObject(response.getBody().toString());

        DAOTrack track = new DAOTrack(json.getString("title"),
                json.getJSONObject("artist").getString("name"),
                json.getJSONObject("album").getString("title"),
                json.getInt("duration")

        );

        return track;
    }

}
