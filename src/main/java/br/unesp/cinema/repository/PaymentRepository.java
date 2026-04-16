package br.unesp.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unesp.cinema.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{
    
}