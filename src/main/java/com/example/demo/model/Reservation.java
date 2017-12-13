package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Reservation
{
    @Id
    private int codeRes;
    private Date dateArrivee;
    private String statRes;
    private String destination;
    private Date heureDArrivee;
    private String commentaire;
    private int nbrVoyageur;

    @DBRef
    private Client client;
    @DBRef
    private Vehicule vehicule;

    public Reservation() {
    }

    public Reservation(int codeRes, Date dateArrivee, String statRes, String destination, Date heureDArrivee, String commentaire, int nbrVoyageur, Client codeClient, Vehicule codeVehicule) {
        this.codeRes = codeRes;
        this.dateArrivee = dateArrivee;
        this.statRes = statRes;
        this.destination = destination;
        this.heureDArrivee = heureDArrivee;
        this.commentaire = commentaire;
        this.nbrVoyageur = nbrVoyageur;
        this.client = codeClient;
        this.vehicule = codeVehicule;
    }

    public int getCodeRes() {
        return codeRes;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public String getStatRes() {
        return statRes;
    }

    public String getDestination() {
        return destination;
    }

    public Date getHeureDArrivee() {
        return heureDArrivee;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getNbrVoyageur() {
        return nbrVoyageur;
    }

    public Client getClient() {
        return client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setCodeRes(int codeRes) {
        this.codeRes = codeRes;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setStatRes(String statRes) {
        this.statRes = statRes;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setHeureDArrivee(Date heureDArrivee) {
        this.heureDArrivee = heureDArrivee;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNbrVoyageur(int nbrVoyageur) {
        this.nbrVoyageur = nbrVoyageur;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
