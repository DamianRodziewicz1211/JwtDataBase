package com.jwtdatabase.dao;

import com.jwtdatabase.model.DAOTrack;
import org.springframework.data.repository.CrudRepository;

public interface TrackDao extends CrudRepository<DAOTrack,Integer> {
}
