package com.jwtdatabase.repository;

import com.jwtdatabase.model.DAOArtist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistDao extends CrudRepository<DAOArtist,Long> {
}
