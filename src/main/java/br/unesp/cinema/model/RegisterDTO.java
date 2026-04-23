package br.unesp.cinema.model;

import java.time.LocalDate;

public record RegisterDTO(String name, String surname, String login, String password, LocalDate birthday, UserRole role) {
    
}
