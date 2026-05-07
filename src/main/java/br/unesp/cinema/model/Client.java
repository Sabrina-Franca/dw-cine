package br.unesp.cinema.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Client")
public class Client extends User{
    @OneToMany(mappedBy="client")
    private List<Purchase> purchasesHistory;

    public Client() {
    }

    public List<Purchase> getPurchasesHistory() {
        return purchasesHistory;
    }

    public void setPurchasesHistory(List<Purchase> purchasesHistory) {
        this.purchasesHistory = purchasesHistory;
    }
}
