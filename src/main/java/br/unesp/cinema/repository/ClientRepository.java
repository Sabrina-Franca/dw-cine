package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    
}