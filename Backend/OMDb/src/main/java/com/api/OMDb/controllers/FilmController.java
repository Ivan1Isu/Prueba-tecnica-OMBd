package com.api.OMDb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.OMDb.services.FilmService;
import com.api.OMDb.models.FilmModel;;

@RestController
@RequestMapping("/film")
public class FilmController {
    
    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public ResponseEntity<List<FilmModel>> getAllMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String year
        ) {
        if(!isVoid(title) && !isVoid(year)) {
            return new ResponseEntity<>(this.filmService.findByTitleAndYear(title, year) , HttpStatus.OK);
        }
        if(!isVoid(title)) {
            return new ResponseEntity<>(this.filmService.findByTitle(title) , HttpStatus.OK);
        }
        if(!isVoid(year)) {
            return new ResponseEntity<>(this.filmService.findByYear(year) , HttpStatus.OK);
        }
        return new ResponseEntity<>(this.filmService.getFilms(), HttpStatus.OK);
    }

    private boolean isVoid(String token) {
        return token == null || token.isEmpty();
    }

}