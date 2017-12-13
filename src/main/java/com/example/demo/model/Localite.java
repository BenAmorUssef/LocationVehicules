package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Localite
{
    @Id
    private int codeLocal;
    private String nomLocal;

    public int getCodeLocal() {
        return codeLocal;
    }

    public String getNomLocal() {
        return nomLocal;
    }

    public Localite(int codeLocal, String nomLocal) {
        this.codeLocal = codeLocal;
        this.nomLocal = nomLocal;
    }

    public Localite() {
    }

    public void setCodeLocal(int codeLocal) {
        this.codeLocal = codeLocal;
    }

    public void setNomLocal(String nomLocal) {
        this.nomLocal = nomLocal;
    }
}
