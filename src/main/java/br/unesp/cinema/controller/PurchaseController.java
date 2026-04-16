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

import br.unesp.cinema.model.Purchase;
import br.unesp.cinema.repository.PurchaseRepository;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Purchase> findOne(@PathVariable(value="id") Long id) {
        Optional<Purchase> purchase = purchaseRepository.findById(id);

        return new ResponseEntity<>(purchase.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Purchase>> findAll() {
        List<Purchase> list = (List<Purchase>) purchaseRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Purchase> register(@RequestBody Purchase purchase) {
        Purchase savedUser = purchaseRepository.save(purchase);
        
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Purchase> update(@RequestBody Purchase purchase){
        Purchase savedUser = purchaseRepository.save(purchase);

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        purchaseRepository.deleteById(id);
        return "Ok!";
    }
}
