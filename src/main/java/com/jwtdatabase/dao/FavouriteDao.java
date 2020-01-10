package com.jwtdatabase.dao;

import com.jwtdatabase.model.DAOFavourite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteDao extends CrudRepository<DAOFavourite,Integer> {
}
