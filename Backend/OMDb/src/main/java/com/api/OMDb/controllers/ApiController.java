package com.api.OMDb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.OMDb.models.DetailedMovieModel;
import com.api.OMDb.models.MovieModel;
import com.api.OMDb.services.ApiService;
import com.api.OMDb.services.FilmService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public ResponseEntity<List<MovieModel>> getAllMovies(){
        return new ResponseEntity<>(this.apiService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<List<DetailedMovieModel>> saveFilms(){

        List<DetailedMovieModel> detailedMovies = this.apiService.getAllDetailedMovie();

        filmService.saveFilms(detailedMovies);

        return new ResponseEntity<>(detailedMovies, HttpStatus.OK);
    }
}