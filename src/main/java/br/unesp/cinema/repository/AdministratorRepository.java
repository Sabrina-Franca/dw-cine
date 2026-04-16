package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Administrator;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long>{
    
}
