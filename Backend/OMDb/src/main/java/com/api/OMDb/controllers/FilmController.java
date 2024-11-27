package com.api.OMDb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.OMDb.services.FilmService;
import com.api.OMDb.models.FilmModel;;

@RestController
@RequestMapping("/film")
public class FilmController {
    
    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public ResponseEntity<List<FilmModel>> getAllMovies(){
        return new ResponseEntity<>(this.filmService.getFilms(), HttpStatus.OK);
    }

}