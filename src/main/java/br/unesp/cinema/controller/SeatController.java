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

import br.unesp.cinema.model.Seat;
import br.unesp.cinema.repository.SeatRepository;

@RestController
@RequestMapping(value = "/seat")
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Seat> findOne(@PathVariable(value="id") Long id) {
        Optional<Seat> seat = seatRepository.findById(id);

        return new ResponseEntity<>(seat.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Seat>> findAll() {
        List<Seat> list = (List<Seat>) seatRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Seat> register(@RequestBody Seat seat) {
        Seat savedSeat = seatRepository.save(seat);
        
        return new ResponseEntity<>(savedSeat, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Seat> update(@RequestBody Seat seat){
        Seat savedSeat = seatRepository.save(seat);

        return new ResponseEntity<>(savedSeat, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        seatRepository.deleteById(id);
        return "Ok!";
    }
}
