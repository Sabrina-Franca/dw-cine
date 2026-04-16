package br.unesp.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.cinema.model.Movie;
import br.unesp.cinema.repository.MovieRepository;

@RestController
@RequestMapping(value="/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Movie> findOne(@PathVariable(value="id") Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        return new ResponseEntity<>(movie.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> list = (List<Movie>) movieRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Movie> register(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        
        return new ResponseEntity<>(savedMovie, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Movie> update(@RequestBody Movie movie){
        Movie savedMovie = movieRepository.save(movie);

        return new ResponseEntity<>(savedMovie, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        movieRepository.deleteById(id);
        return "Ok!";
    }
}
