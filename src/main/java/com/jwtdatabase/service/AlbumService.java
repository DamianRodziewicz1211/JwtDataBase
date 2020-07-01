package com.jwtdatabase.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jwtdatabase.json.AlbumSerializer;
import com.jwtdatabase.model.DAOAlbum;
import com.jwtdatabase.repository.AlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    @Autowired
    private AlbumDao albumRepository;

    public String getAlbum(Integer id){
        try{
            DAOAlbum album = deezer.searchAlbum(id);

            ObjectMapper mapper = new ObjectMapper();

            SimpleModule module = new SimpleModule();
            module.addSerializer(DAOAlbum.class, new AlbumSerializer());
            mapper.registerModule(module);

            String serializedAlbum = mapper.writeValueAsString(album);

            return serializedAlbum;



        } catch(Exception e){
            e.getMessage();
        }
        return "No album found with given Id";
    }

    public String addAlbum(Integer id){
        try {
            DAOAlbum newAlbum = deezer.searchAlbum(id);
            albumRepository.save(newAlbum);
            return  "Album "+"\"" + newAlbum.getTitle() + "\"" +
                    " has been added to favourites with id "+ newAlbum.getAlbumId();
        }catch(Exception e){
            e.printStackTrace();
        }

        return "Album with given Id doesn't exist";
    }

    public boolean deleteAlbum(long id){
        albumRepository.deleteById(id);

        if(!albumRepository.existsById(id))
            return true;
        else
            return false;
    }

    public List<DAOAlbum> printAlbums() {

        List<DAOAlbum> albums = new ArrayList<>();
        Iterable<DAOAlbum> repositoryAlbums = albumRepository.findAll();

        repositoryAlbums.forEach(albums::add);

        return albums;

    }
}
