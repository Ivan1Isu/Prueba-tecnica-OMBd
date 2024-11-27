package com.api.OMDb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OMDb.models.DetailedMovieModel;
import com.api.OMDb.models.FilmModel;
import com.api.OMDb.repositories.IFilmRepository;

@Service
public class FilmService {
    
    @Autowired
    IFilmRepository filmRepository;

    public ArrayList<FilmModel> getFilms() {
        return (ArrayList<FilmModel>) filmRepository.findAll();
     }

    public FilmModel saveFilm(FilmModel film) {
        return filmRepository.save(film);
    }

    public List<FilmModel> saveFilms(List<DetailedMovieModel> detailedMovies) {

        List<FilmModel> savedFilms = new ArrayList<>();

        for (DetailedMovieModel movie : detailedMovies){

            FilmModel film = new FilmModel(movie.getTitle(), 
                movie.getYear(), 
                movie.getImdbID(), 
                movie.getPlot()
            );
            savedFilms.add(this.saveFilm(film));
        }
        return savedFilms;
    }

    public List<FilmModel> findByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<FilmModel> findByYear(String year) {
        return filmRepository.findByYear(year);
    }

    public List<FilmModel> findByTitleAndYear(String title, String year) {
        return filmRepository.findByTitleContainingIgnoreCaseAndYear(title, year);
    }

    public List<FilmModel> findByTitleAndYearGreaterThanEqual(String title, String year) {
        return filmRepository.findByTitleContainingIgnoreCaseAndYearGreaterThanEqual(title, year);
    }

    public List<FilmModel> findByTitleAndYearGreaterThan(String title, String year) {
        return filmRepository.findByTitleContainingIgnoreCaseAndYearGreaterThan(title, year);
    }
    
}
