package com.jwtdatabase.repository;

import com.jwtdatabase.model.DAOTrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackDao extends CrudRepository<DAOTrack,Long> {
    long deleteByTitle(String title);
}
