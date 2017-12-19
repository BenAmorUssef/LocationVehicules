package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Administrateur
{
    @Id
    private int codeAdmin;
    private String nomAdmin;
    private String addressAdmin;
    private String mailAdmin;
    private String typeAdmin;
    @DBRef
    private Compte codeCompte;
    @DBRef
    private List<Reservation> reservations;

    public Administrateur() {
    }

    public Administrateur(int codeAdmin, String nomAdmin, String addressAdmin, String mailAdmin, String typeAdmin, Compte codeCompte, List<Reservation> reservations) {
        this.codeAdmin = codeAdmin;
        this.nomAdmin = nomAdmin;
        this.addressAdmin = addressAdmin;
        this.mailAdmin = mailAdmin;
        this.typeAdmin = typeAdmin;
        this.codeCompte = codeCompte;
        this.reservations = reservations;
    }

    public int getCodeAdmin() {
        return codeAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public String getAddressAdmin() {
        return addressAdmin;
    }

    public String getMailAdmin() {
        return mailAdmin;
    }

    public String getTypeAdmin() {
        return typeAdmin;
    }

    public Compte getCodeCompte() {
        return codeCompte;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setCodeAdmin(int codeAdmin) {
        this.codeAdmin = codeAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public void setAddressAdmin(String addressAdmin) {
        this.addressAdmin = addressAdmin;
    }

    public void setMailAdmin(String mailAdmin) {
        this.mailAdmin = mailAdmin;
    }

    public void setTypeAdmin(String typeAdmin) {
        this.typeAdmin = typeAdmin;
    }

    public void setCodeCompte(Compte codeCompte) {
        this.codeCompte = codeCompte;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
