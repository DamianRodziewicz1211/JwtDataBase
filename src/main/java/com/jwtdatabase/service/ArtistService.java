package com.jwtdatabase.service;


import com.jwtdatabase.model.DAOArtist;
import com.jwtdatabase.repository.ArtistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    @Autowired
    private ArtistDao artistRepository;

    public String getArtist(String id){
        try{
            DAOArtist newArtist = deezer.searchArtist(id);
            return newArtist.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Something missing";
    }

    public Long addArtist(String id){
        try{
            DAOArtist newArtist = deezer.searchArtist(id);
            artistRepository.save(newArtist);
            return newArtist.getArtistId();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1l;
    }

    public boolean deleteArtist(long id){
        artistRepository.deleteById(id);
        if(!artistRepository.existsById(id))
            return true;
        else
            return false;
    }
}
