package br.unesp.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String synopsis;
    private int ageClassification;
    private String genre;
    private int duration;
    private String screewriter;
    private String director;
    
    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getAgeClassification() {
        return ageClassification;
    }

    public void setAgeClassification(int ageClassification) {
        this.ageClassification = ageClassification;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getScreewriter() {
        return screewriter;
    }

    public void setScreewriter(String screewriter) {
        this.screewriter = screewriter;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    
}
