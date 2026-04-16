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

import br.unesp.cinema.model.Administrator;
import br.unesp.cinema.repository.AdministratorRepository;

@RestController
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    private AdministratorRepository adminRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Administrator> findOne(@PathVariable(value = "id") Long id) {
        Optional<Administrator> admin = adminRepository.findById(id);

        return new ResponseEntity<>(admin.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Administrator>> findAll() {
        List<Administrator> list = (List<Administrator>) adminRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Administrator> register(@RequestBody Administrator admin) {
        Administrator savedAdmin = adminRepository.save(admin);

        return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Administrator> update(@RequestBody Administrator admin) {
        Administrator savedAdmin = adminRepository.save(admin);

        return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String delete(@PathVariable("id") Long id) {
        adminRepository.deleteById(id);
        return "Ok!";
    }
}
