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

import br.unesp.cinema.model.Client;
import br.unesp.cinema.repository.ClientRepository;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Client> findOne(@PathVariable(value="id") Long id) {
        Optional<Client> client = clientRepository.findById(id);

        return new ResponseEntity<>(client.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = (List<Client>) clientRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<Client> register(@RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        
        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Client> update(@RequestBody Client client){
        Client savedClient = clientRepository.save(client);

        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        clientRepository.deleteById(id);
        return "Ok!";
    }
}
