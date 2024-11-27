package com.api.OMDb.models;

import java.util.List;

public class ApiResponseModel {
    
    private List<MovieModel> Search;
    private String totalResults;
    private String Response;

    public ApiResponseModel(List<MovieModel> Search, String totalResults, String Response) {
        super();
        this.Search = Search;
        this.totalResults = totalResults;
        this.Response = Response;
    }


    public List<MovieModel> getSearch() { return Search; }
    public void setSearch(List<MovieModel> Search) { this.Search = Search; }

    public String getTotalResults() { return totalResults; }
    public void setTotalResults(String totalResults) { this.totalResults = totalResults; }

    public String getResponse() { return Response; }
    public void setResponse(String Response) { this.Response = Response; }   
}

