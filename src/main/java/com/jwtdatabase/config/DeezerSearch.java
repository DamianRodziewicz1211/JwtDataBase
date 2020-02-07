package com.jwtdatabase.config;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.net.URLEncoder;

public class DeezerSearch {

    private String rapidapiHost = "deezerdevs-deezer.p.rapidapi.com";

    // Klucz rapidApi generowany dla konta na stronie rapidAPI
    private String rapidapiKey = "6c7906ce15msh5277a249c6b8a50p15dbecjsn396b42a7eec8";

    public String search( String q) throws Exception{

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

    public String searchAlbum (String id) throws Exception {

        String host = "https://api.deezer.com/album/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;


    }

    public String searchArtist(String id) throws Exception{

        String host = "https://api.deezer.com/artist/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;
    }

    public String searchTrack(String id) throws Exception{

        String host = "https://api.deezer.com/track/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;
    }

    public String searchPlaylist(String id) throws Exception{

        String host = "https://api.deezer.com/playlist/";
        String charset = "UTF-8";

        HttpResponse<JsonNode> response = Unirest.get(host + id)
                .header("rapidapiHost",rapidapiHost)
                .header("rapidKey",rapidapiKey)
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;
    }
}
