package com.api.OMDb.controllers;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public ResponseEntity<List<MovieModel>> getAllMovies(){
        return new ResponseEntity<>(this.apiService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/detailed")
    public ResponseEntity<List<DetailedMovieModel>> getAllDetailedMovies(){
        List<MovieModel> Movies  = this.apiService.getMovies();

        List<DetailedMovieModel> detailedMovies = new ArrayList<DetailedMovieModel>();
        for (MovieModel movie : Movies){
            detailedMovies.add(this.apiService.getDetailedMovie(movie.getImdbID()));
        }

        return new ResponseEntity<>(detailedMovies, HttpStatus.OK);
    }
}