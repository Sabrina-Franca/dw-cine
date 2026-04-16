package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
    
}