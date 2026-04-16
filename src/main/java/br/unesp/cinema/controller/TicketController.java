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

import br.unesp.cinema.model.Ticket;
import br.unesp.cinema.repository.TicketRepository;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Ticket> findOne(@PathVariable(value="id") Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);

        return new ResponseEntity<>(ticket.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Ticket>> findAll() {
        List<Ticket> list = (List<Ticket>) ticketRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Ticket> register(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        
        return new ResponseEntity<>(savedTicket, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Ticket> update(@RequestBody Ticket ticket){
        Ticket savedTicket = ticketRepository.save(ticket);

        return new ResponseEntity<>(savedTicket, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        ticketRepository.deleteById(id);
        return "Ok!";
    }
}
