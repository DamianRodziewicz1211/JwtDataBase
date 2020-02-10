package com.jwtdatabase.repository;

import com.jwtdatabase.model.DAOPlaylist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistDao extends CrudRepository<DAOPlaylist,Long> {

}
