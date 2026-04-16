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

import br.unesp.cinema.model.Session;
import br.unesp.cinema.repository.SessionRepository;

@RestController
@RequestMapping(value = "/session")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Session> findOne(@PathVariable(value="id") Long id) {
        Optional<Session> session = sessionRepository.findById(id);

        return new ResponseEntity<>(session.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Session>> findAll() {
        List<Session> list = (List<Session>) sessionRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Session> register(@RequestBody Session session) {
        Session savedSession = sessionRepository.save(session);
        
        return new ResponseEntity<>(savedSession, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Session> update(@RequestBody Session session){
        Session savedSession = sessionRepository.save(session);

        return new ResponseEntity<>(savedSession, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        sessionRepository.deleteById(id);
        return "Ok!";
    }
}
