package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long>{
    
}