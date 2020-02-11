package com.jwtdatabase.service;

import com.jwtdatabase.repository.TrackDao;
import com.jwtdatabase.model.DAOTrack;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public  class TrackService {


    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    @Autowired
    private TrackDao tracksRepository;

    public String getTrack(Integer id){

        try{
            DAOTrack track = deezer.searchTrack(id);
            return track.toString();
        } catch(Exception e){
            e.getMessage();
        }
        return "No Track found with given Id";
    }

    public String addTrack(Integer id){
        try {
            DAOTrack newTrack = deezer.searchTrack(id);

            tracksRepository.save(newTrack);
            return  "Track "+"\"" + newTrack.getTitle() + "\"" +
                    " has been added to favourites with id "+ newTrack.getTrackId();
        }catch(Exception e) {
            e.getMessage();
        }

        return "Track with given Id doesn't exist";
    }

    public boolean deleteTrack(long id){
        tracksRepository.deleteById(id);

        if(!tracksRepository.existsById(id))
            return true;
        else
            return false;
    }

    public String printTracks(){
        return tracksRepository.findAll().toString();
    }
}
