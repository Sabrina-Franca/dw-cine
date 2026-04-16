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

import br.unesp.cinema.model.User;
import br.unesp.cinema.repository.UserRepository;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<User> findOne(@PathVariable(value="id") Long id) {
        Optional<User> user = userRepository.findById(id);

        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = (List<User>) userRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping(value="/", produces = "application/json")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<User> update(@RequestBody User user){
        User savedUser = userRepository.save(user);

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", produces="application/json")
    public String delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "Ok!";
    }
}
