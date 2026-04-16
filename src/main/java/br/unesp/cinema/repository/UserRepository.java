package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
