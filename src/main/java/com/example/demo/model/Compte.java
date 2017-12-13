package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Compte
{
    @Id
    private int codeCompte;
    private String login;
    private String motDePasse;

    public Compte() {
    }

    public Compte(int codeCompte, String login, String motDePasse) {
        this.codeCompte = codeCompte;
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public int getCodeCompte() {
        return codeCompte;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setCodeCompte(int codeCompte) {
        this.codeCompte = codeCompte;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
