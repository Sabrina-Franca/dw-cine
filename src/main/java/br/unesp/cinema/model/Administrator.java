package br.unesp.cinema.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends User{

    public Administrator() {
    }
}
