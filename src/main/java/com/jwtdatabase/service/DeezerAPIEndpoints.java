package com.jwtdatabase.service;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jwtdatabase.json.AlbumSerializer;
import com.jwtdatabase.json.TrackSerializer;
import com.jwtdatabase.model.*;
import com.jwtdatabase.repository.UserDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


import java.net.URLEncoder;
import java.util.*;


public class DeezerAPIEndpoints {

    @Autowired
    private UserDao userRepo;

    private String rapidapiHost = "deezerdevs-deezer.p.rapidapi.com";

    private String rapidapiKey = "6c7906ce15msh5277a249c6b8a50p15dbecjsn396b42a7eec8";

    private String host = "https://api.deezer.com/search";

    private String charset = "UTF-8";


    public String search( String q) throws Exception {

        String query = String.format(("q=%s"), URLEncoder.encode(q,charset));

        HttpResponse<String> response = Unirest.get(host + "?" + query)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asString();

        JSONObject json = new JSONObject((response.getBody()));
        JSONArray trackList = json.getJSONArray("data");


        List<DAOTrack> tracks = new ArrayList<>();

        if(trackList != null){
            for(Integer i=0;i<trackList.length();i++){
                JSONObject tmp = trackList.getJSONObject(i);
                DAOTrack track = new DAOTrack(
                        tmp.getString("title"),
                        tmp.getJSONObject("artist").getString("name"),
                        tmp.getJSONObject("album").getString("title"),
                        tmp.getInt("duration"),
                        tmp.getString("preview"),
                        tmp.getJSONObject("album").getString("cover"),
                        tmp.getInt("id")
                );
                tracks.add(track);
            }
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(DAOTrack.class, new TrackSerializer());
            mapper.registerModule(module);

            List<String> serializedSearch = new ArrayList<>();

            for(Integer i=0;i<tracks.size();i++){

                serializedSearch.add(mapper.writeValueAsString(tracks.get(i)));

            }
            return serializedSearch.toString();
        }
        return "no results";

    }

    public String findAlbums(String q) throws Exception {


        String query = String.format(("q=%s"), URLEncoder.encode(q,charset));

        HttpResponse<String> response = Unirest.get(host + "?" + query)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asString();

        JSONObject json = new JSONObject((response.getBody()));
        JSONArray trackList = json.getJSONArray("data");

        //set for storing albums id without duplicates
        Set<Integer> albumIds = new HashSet<>();
        List<DAOAlbum> listOfAlbums = new ArrayList<>();
        List<String> serializedAlbums = new ArrayList<>();

        if(trackList != null){
            for( Integer i=0; i < trackList.length();i++){
                JSONObject tmp = trackList.getJSONObject(i);
                albumIds.add(tmp.getJSONObject("album").getInt("id"));
            }

            for( Integer id : albumIds){
                DAOAlbum tmp = searchAlbum(id);
                listOfAlbums.add(tmp);
            }

            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(DAOAlbum.class,new AlbumSerializer());
            mapper.registerModule(module);

            for(Integer i=0;i<listOfAlbums.size();i++)
                serializedAlbums.add(mapper.writeValueAsString(listOfAlbums.get(i)));

            return serializedAlbums.toString();
        }
        return "No results";
    }

    public DAOAlbum searchAlbum (Integer id) throws Exception {

        String host = "https://api.deezer.com/album/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id.toString())
                    .header("rapidapiHost", rapidapiHost)
                    .header("rapidKey", rapidapiKey)
                    .asJson();


        Map<String, String> listOfTracks = new HashMap<>();

        JSONObject json = new JSONObject(response.getBody().toString());
        JSONArray trackList = json.getJSONObject("tracks").getJSONArray("data");
        JSONObject genre = json.getJSONObject("genres").getJSONArray("data").getJSONObject(0);


        for (Integer i = 0; i < trackList.length(); i++) {
            JSONObject track = trackList.getJSONObject(i);
            listOfTracks.put(i.toString(), track.getString("preview"));
        }

        DAOAlbum album = new DAOAlbum(
                json.getString("title"),
                json.getJSONObject("artist").getString("name"),
                listOfTracks,
                genre.getString("name"),
                json.getString("cover"),
                json.getInt("id")
        );

            return album;


    }

    public DAOArtist searchArtist(Integer id) throws Exception{

        String host = "https://api.deezer.com/artist/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id.toString())
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

    public DAOTrack searchTrack(Integer id) throws Exception {

        String host = "https://api.deezer.com/track/";
        String charset = "UTF-8";
        ObjectMapper objectMapper = new ObjectMapper();

        HttpResponse<JsonNode> response = Unirest.get(host + id.toString())
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        JSONObject json = new JSONObject(response.getBody().toString());

        DAOTrack track = new DAOTrack(json.getString("title"),
                    json.getJSONObject("artist").getString("name"),
                    json.getJSONObject("album").getString("title"),
                    json.getInt("duration"),
                    json.getString("preview"),
                    json.getJSONObject("album").getString("cover"),
                    json.getInt("id"));



        return track;

    }

}
