package com.jwtdatabase.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jwtdatabase.json.ArtistSerializer;
import com.jwtdatabase.model.DAOArtist;
import com.jwtdatabase.repository.ArtistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ArtistService {

    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    @Autowired
    private ArtistDao artistRepository;

    public String getArtist(Integer id){
        try{
            DAOArtist newArtist = deezer.searchArtist(id);
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();

            module.addSerializer(DAOArtist.class, new ArtistSerializer());
            mapper.registerModule(module);

            String serializerArtist = mapper.writeValueAsString(newArtist);
            return serializerArtist;


        }catch(Exception e){
            e.printStackTrace();
        }
        return "No artist found with given Id";
    }

    public String addArtist(Integer id){
        try{
            DAOArtist newArtist = deezer.searchArtist(id);
            artistRepository.save(newArtist);
            return "Artist "+"\"" + newArtist.getArtistName() + "\"" +
                    " has been added to favourites with id "+ newArtist.getArtistId();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Artist with given Id doesn't exist";
    }

    public boolean deleteArtist(long id){
        artistRepository.deleteById(id);
        if(!artistRepository.existsById(id))
            return true;
        else
            return false;
    }

    public List<DAOArtist> printArtists() {

        List<DAOArtist> artists = new ArrayList<>();
        Iterable<DAOArtist> repositoryArtists = artistRepository.findAll();

        repositoryArtists.forEach(artists::add);

        return artists;
    }
}
