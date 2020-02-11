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

    public String getArtist(Integer id){
        try{
            DAOArtist newArtist = deezer.searchArtist(id);
            return newArtist.toString();
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
}
