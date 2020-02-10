package com.jwtdatabase.repository;

import com.jwtdatabase.model.DAOAlbum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumDao extends CrudRepository<DAOAlbum,Long> {
}
