package com.api.OMDb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.OMDb.models.FilmModel;

@Repository
public interface IFilmRepository  extends JpaRepository<FilmModel, Long> {

    List<FilmModel> findByTitleContainingIgnoreCase(String title);
    List<FilmModel> findByYear(String year);
    List<FilmModel> findByTitleContainingIgnoreCaseAndYear(String title, String year);
}
