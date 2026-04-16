package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{
    
}