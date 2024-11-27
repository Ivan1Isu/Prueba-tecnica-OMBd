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
    private String title;
    @Column
    private String year;
    @Column
    private String plot;
    
    public FilmModel() {}

    public FilmModel( String Title, String Year, String imdbID, String Plot) {
        this.imdbID = imdbID;
        this.title = Title;
        this.year = Year;
        this.plot = Plot;
    }

    public String getImdbID() { return imdbID; }
    public void setImdbID(String imdbID) { this.imdbID = imdbID; }

    public String getTitle() { return title; }
    public void setTitle(String Title) { this.title = Title; }

    public String getYear() { return year; }
    public void setYear(String Year) { this.year = Year; }

    public String getPlot() { return plot; }
    public void setYPlot(String Plot) { this.plot = Plot; }
    
}

