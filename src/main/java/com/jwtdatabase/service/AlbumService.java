package com.jwtdatabase.service;


import com.jwtdatabase.model.DAOAlbum;
import com.jwtdatabase.repository.AlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    @Autowired
    private AlbumDao albumRepository;

    public String getAlbum(String id){
        try{
            DAOAlbum album = deezer.searchAlbum(id);
            return album.toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return "something missing";
    }

    public long addAlbum(String id){
        try {
            DAOAlbum newAlbum = deezer.searchAlbum(id);
            albumRepository.save(newAlbum);
            return  newAlbum.getAlbumId();
        }catch(Exception e){
            e.printStackTrace();
        }

        return -1;
    }

    public boolean deleteAlbum(long id){
        albumRepository.deleteById(id);

        if(!albumRepository.existsById(id))
            return true;
        else
            return false;
    }
}
