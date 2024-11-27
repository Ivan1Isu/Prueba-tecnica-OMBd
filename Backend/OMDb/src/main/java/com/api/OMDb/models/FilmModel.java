package com.api.OMDb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Film")
public class FilmModel {

    @Id
    private String imdbID;
    @Column
    private String Title;
    @Column
    private String Year;
    @Column
    private String Plot;
    
    public FilmModel() {}

    public FilmModel( String Title, String Year, String imdbID, String Plot) {
        this.imdbID = imdbID;
        this.Title = Title;
        this.Year = Year;
        this.Plot = Plot;
    }

    public String getImdbID() { return imdbID; }
    public void setImdbID(String imdbID) { this.imdbID = imdbID; }

    public String getTitle() { return Title; }
    public void setTitle(String Title) { this.Title = Title; }

    public String getYear() { return Year; }
    public void setYear(String Year) { this.Year = Year; }

    public String getPlot() { return Plot; }
    public void setYPlot(String Plot) { this.Plot = Plot; }
    
}

