package com.api.OMDb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.OMDb.models.FilmModel;

@Repository
public interface IFilmRepository  extends JpaRepository<FilmModel, Long> {
    
}
