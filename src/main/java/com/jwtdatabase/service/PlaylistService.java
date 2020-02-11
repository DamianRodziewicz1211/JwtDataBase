package com.jwtdatabase.service;

import com.jwtdatabase.model.DAOPlaylist;
import com.jwtdatabase.model.DAOTrack;
import com.jwtdatabase.repository.PlaylistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService{

    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    private Integer size = 1;

    @Autowired
    private PlaylistDao playlistRepository;

    public long createPlaylist(String name,String description){
        try{
            DAOPlaylist newPlaylist = new DAOPlaylist(name,description);
            playlistRepository.save(newPlaylist);

            return newPlaylist.getPlaylistId();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1l;
    }

    public String addToPlaylist(Long playlist_id,Integer id){
        try{
            DAOTrack newTrack = deezer.searchTrack(id);
            DAOPlaylist playlist = playlistRepository.findById(playlist_id).get();
            playlist.getPlaylistTracks().put(size++,newTrack.getTitle());
            playlistRepository.save(playlist);
            return "Track "+ "\"" + newTrack.getTitle()+ "\"" + " added to playlist "+playlist_id;
        }catch(Exception e){
            e.getMessage();
        }
        return "Track/Playlist with given id not found";
    }

    public boolean deletePlaylist(long id){
        playlistRepository.deleteById(id);
        if(!playlistRepository.existsById(id))
            return true;
        else
            return false;
    }

}
