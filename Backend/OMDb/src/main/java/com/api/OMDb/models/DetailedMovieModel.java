package com.api.OMDb.models;

import java.util.List;

public class DetailedMovie extends MovieModel{
    
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private List<Rating> Ratings;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String Response;

    public DetailedMovie(String Title, String Year, String imdbID, String Type, String Poster,
                         String Rated, String Released, String Runtime, String Genre, String Director,
                         String Writer, String Actors, String Plot, String Language, String Country,
                         String Awards, List<Rating> Ratings, String Metascore, String imdbRating,
                         String imdbVotes, String BoxOffice, String Production, String Website, String Response) {

        super(Title, Year, imdbID, Type, Poster);  // Llamamos al constructor de MovieModel
        this.Rated = Rated;
        this.Released = Released;
        this.Runtime = Runtime;
        this.Genre = Genre;
        this.Director = Director;
        this.Writer = Writer;
        this.Actors = Actors;
        this.Plot = Plot;
        this.Language = Language;
        this.Country = Country;
        this.Awards = Awards;
        this.Ratings = Ratings;
        this.Metascore = Metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.BoxOffice = BoxOffice;
        this.Production = Production;
        this.Website = Website;
        this.Response = Response;
    }

    // Getters and Setters
    public String getRated() { return Rated; }
    public void setRated(String Rated) { this.Rated = Rated; }

    public String getReleased() { return Released; }
    public void setReleased(String Released) { this.Released = Released; }

    public String getRuntime() { return Runtime; }
    public void setRuntime(String Runtime) { this.Runtime = Runtime; }

    public String getGenre() { return Genre; }
    public void setGenre(String Genre) { this.Genre = Genre; }

    public String getDirector() { return Director; }
    public void setDirector(String Director) { this.Director = Director; }

    public String getWriter() { return Writer; }
    public void setWriter(String Writer) { this.Writer = Writer; }

    public String getActors() { return Actors; }
    public void setActors(String Actors) { this.Actors = Actors; }

    public String getPlot() { return Plot; }
    public void setPlot(String Plot) { this.Plot = Plot; }

    public String getLanguage() { return Language; }
    public void setLanguage(String Language) { this.Language = Language; }

    public String getCountry() { return Country; }
    public void setCountry(String Country) { this.Country = Country; }

    public String getAwards() { return Awards; }
    public void setAwards(String Awards) { this.Awards = Awards; }

    public List<Rating> getRatings() { return Ratings; }
    public void setRatings(List<Rating> Ratings) { this.Ratings = Ratings; }

    public String getMetascore() { return Metascore; }
    public void setMetascore(String Metascore) { this.Metascore = Metascore; }

    public String getImdbRating() { return imdbRating; }
    public void setImdbRating(String imdbRating) { this.imdbRating = imdbRating; }

    public String getImdbVotes() { return imdbVotes; }
    public void setImdbVotes(String imdbVotes) { this.imdbVotes = imdbVotes; }

    public String getBoxOffice() { return BoxOffice; }
    public void setBoxOffice(String BoxOffice) { this.BoxOffice = BoxOffice; }

    public String getProduction() { return Production; }
    public void setProduction(String Production) { this.Production = Production; }

    public String getWebsite() { return Website; }
    public void setWebsite(String Website) { this.Website = Website; }

    public String getResponse() { return Response; }
    public void setResponse(String Response) { this.Response = Response; }

    // Clases para los Ratings
    public static class Rating {
        private String Source;
        private String Value;

        public Rating(String Source, String Value) {
            this.Source = Source;
            this.Value = Value;
        }

        public String getSource() { return Source; }
        public void setSource(String Source) { this.Source = Source; }

        public String getValue() { return Value; }
        public void setValue(String Value) { this.Value = Value; }
    }


}
