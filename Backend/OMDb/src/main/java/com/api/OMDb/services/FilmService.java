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

    public List<FilmModel> findByTitleAndYearLessThanEqual(String title, String year) {
        return filmRepository.findByTitleContainingIgnoreCaseAndYearLessThanEqual(title, year);
    }

    public List<FilmModel> findByTitleAndYearLessThan(String title, String year) {
        return filmRepository.findByTitleContainingIgnoreCaseAndYearLessThan(title, year);
    }

    public List<FilmModel> findByYearGreaterThanEqual( String year) {
        return filmRepository.findByYearGreaterThanEqual(year);
    }

    public List<FilmModel> findByYearGreaterThan(String year) {
        return filmRepository.findByYearGreaterThan(year);
    }

    public List<FilmModel> findByYearLessThanEqual(String year) {
        return filmRepository.findByYearLessThan(year);
    }

    public List<FilmModel> findByYearLessThan(String year) {
        return filmRepository.findByYearLessThanEqual(year);
    }
    
}
