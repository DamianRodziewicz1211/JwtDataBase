package com.jwtdatabase.service;

import com.jwtdatabase.repository.TrackDao;
import com.jwtdatabase.model.DAOTrack;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class TrackService {


    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    @Autowired
    private TrackDao tracksRepository;

    public String getTrack(String id){

        try{
            DAOTrack track = deezer.searchTrack(id);
            return track.toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return "something missing";
    }

    public long addTrack(String id){
        try {
            DAOTrack newTrack = deezer.searchTrack(id);
            tracksRepository.save(newTrack);
            return  newTrack.getTrackId();
        }catch(Exception e){
            e.printStackTrace();
        }

        return -1;
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
