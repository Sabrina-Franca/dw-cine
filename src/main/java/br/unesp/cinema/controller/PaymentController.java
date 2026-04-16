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

import br.unesp.cinema.model.Payment;
import br.unesp.cinema.repository.PaymentRepository;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Payment> findOne(@PathVariable(value="id") Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);

        return new ResponseEntity<>(payment.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> list = (List<Payment>) paymentRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Payment> register(@RequestBody Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        
        return new ResponseEntity<>(savedPayment, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Payment> update(@RequestBody Payment payment){
        Payment savedPayment = paymentRepository.save(payment);

        return new ResponseEntity<>(savedPayment, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        paymentRepository.deleteById(id);
        return "Ok!";
    }
}
