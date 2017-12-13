package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicule
{
    @Id
    private String matricule;
    private String marqueVeh;
    private String puissanceVeh;
    private int nombrePlace;
    @DBRef
    private TypeVehicule typeVehicule;
    @DBRef
    private Localite localite;

    public Vehicule() {
    }

    public Vehicule(String matricule, String marqueVeh, String puissanceVeh, int nombrePlace, TypeVehicule typeVehicule, Localite localite) {
        this.matricule = matricule;
        this.marqueVeh = marqueVeh;
        this.puissanceVeh = puissanceVeh;
        this.nombrePlace = nombrePlace;
        this.typeVehicule = typeVehicule;
        this.localite = localite;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarqueVeh() {
        return marqueVeh;
    }

    public String getPuissanceVeh() {
        return puissanceVeh;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarqueVeh(String marqueVeh) {
        this.marqueVeh = marqueVeh;
    }

    public void setPuissanceVeh(String puissanceVeh) {
        this.puissanceVeh = puissanceVeh;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }
}
