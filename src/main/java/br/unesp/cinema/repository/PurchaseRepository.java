package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long>{
    
}