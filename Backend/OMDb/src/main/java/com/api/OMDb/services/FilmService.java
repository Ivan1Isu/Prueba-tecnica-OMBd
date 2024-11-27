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
    private IFilmRepository filmRepository;

    public ArrayList<FilmModel> getFilms() {
        return (ArrayList<FilmModel>) this.filmRepository.findAll();
     }

    public FilmModel saveFilm(FilmModel film) {
        return this.filmRepository.save(film);
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
        return this.filmRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<FilmModel> findByYear(String year) {
        return this.filmRepository.findByYear(year);
    }

    public List<FilmModel> findByTitleAndYear(String title, String year) {
        return this.filmRepository.findByTitleContainingIgnoreCaseAndYear(title, year);
    }

    public List<FilmModel> findByTitleAndYearWithOp(String title, String year, String op) {
        switch(op) {
            case "GT":
                return this.filmRepository.findByTitleContainingIgnoreCaseAndYearGreaterThan(title, year);
            case "GTE":
                return this.filmRepository.findByTitleContainingIgnoreCaseAndYearGreaterThanEqual(title, year);
            case "LT":
                return this.filmRepository.findByTitleContainingIgnoreCaseAndYearLessThan(title, year);
            case "LTE":
                return this.filmRepository.findByTitleContainingIgnoreCaseAndYearLessThanEqual(title, year);
            default:
                throw new IllegalArgumentException("Operador no soportado: " + op);
        }
    }

    public List<FilmModel> findByYearWithOp (String year, String op) {
        switch(op) {
            case "GT":
                return this.filmRepository.findByYearGreaterThan(year);
            case "GTE":
                return this.filmRepository.findByYearGreaterThanEqual(year);
            case "LT":
                return this.filmRepository.findByYearLessThan(year);
            case "LTE":
                return this.filmRepository.findByYearLessThanEqual(year);
            default:
                throw new IllegalArgumentException("Operador no soportado: " + op);
        }
    }


    
}
