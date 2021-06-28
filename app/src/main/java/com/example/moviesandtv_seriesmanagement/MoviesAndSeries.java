package com.example.moviesandtv_seriesmanagement;

public class MoviesAndSeries {
    private String Name;
    private String Season;
    private String MovieOrTV;


    public MoviesAndSeries(String name, String season, String movieOrTV) {
        Name = name;
        Season = season;
        MovieOrTV = movieOrTV;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public String getMovieOrTV() {
        return MovieOrTV;
    }

    public void setMovieOrTV(String movieOrTV) {
        MovieOrTV = movieOrTV;
    }

    @Override
    public String toString() {
        return "MoviesAndSeries{" +
                "Name='" + Name + '\'' +
                ", Season='" + Season + '\'' +
                ", MovieOrTV='" + MovieOrTV + '\'' +
                '}';
    }
}
