package com.api.OMDb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.OMDb.config.ApiConfig;
import com.api.OMDb.models.ApiResponseModel;
import com.api.OMDb.models.DetailedMovieModel;
import com.api.OMDb.models.MovieModel;

@Service
public class ApiService {
 
    private final ApiConfig apiConfig;

    public ApiService(ApiConfig apiConfig) { this.apiConfig = apiConfig; }

    @Autowired
    private RestTemplate restTemplate;

    public List<MovieModel> getMovies() {
        
        String url = apiConfig.getUrl() +"apikey="+ apiConfig.getKey() + "&s=Star+Wars&type=movie";

        ApiResponseModel APIResponse = this.restTemplate.getForObject(url, ApiResponseModel.class);

        return APIResponse.getSearch();

    }    

    public DetailedMovieModel getDetailedMovie(String imdbID) {
        
        String url = apiConfig.getUrl() +"apikey="+ apiConfig.getKey() + "&i="+ imdbID;

        DetailedMovieModel detailedMovie = this.restTemplate.getForObject(url, DetailedMovieModel.class);

        return detailedMovie;

    }   
        
}