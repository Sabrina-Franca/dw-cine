package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long>{
    
}