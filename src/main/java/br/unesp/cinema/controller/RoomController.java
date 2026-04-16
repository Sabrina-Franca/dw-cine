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

import br.unesp.cinema.model.Room;
import br.unesp.cinema.repository.RoomRepository;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Room> findOne(@PathVariable(value="id") Long id) {
        Optional<Room> room = roomRepository.findById(id);

        return new ResponseEntity<>(room.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Room>> findAll() {
        List<Room> list = (List<Room>) roomRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Room> register(@RequestBody Room room) {
        Room savedRoom = roomRepository.save(room);
        
        return new ResponseEntity<>(savedRoom, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Room> update(@RequestBody Room room){
        Room savedRoom = roomRepository.save(room);

        return new ResponseEntity<>(savedRoom, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        roomRepository.deleteById(id);
        return "Ok!";
    }
}
