package com.api.OMDb.models;

public class MovieModel {

    private String Title;
    private String Year;

    private String imdbID;
    private String Type;
    private String Poster;

    public MovieModel( String Title, String Year, String imdbID, String Type, String Poster) {
        this.imdbID = imdbID;
        this.Title = Title;
        this.Year = Year;
        this.Type = Type;
        this.Poster = Poster;
    }

    public String getImdbID() { return imdbID; }
    public void setImdbID(String imdbID) { this.imdbID = imdbID; }

    public String getTitle() { return Title; }
    public void setTitle(String Title) { this.Title = Title; }

    public String getYear() { return Year; }
    public void setYear(String Year) { this.Year = Year; }

    public String getType() { return Type; }
    public void setYType(String Type) { this.Type = Type; }

    public String getPoster() { return Poster; }
    public void setPoster(String Poster) { this.Poster = Poster; }
    
}
