package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TypeVehicule
{
    @Id
    private int codeType;
    private String nomType;
    private float telf;

    public TypeVehicule(int codeType, String nomType, float telf) {
        this.codeType = codeType;
        this.nomType = nomType;
        this.telf = telf;
    }

    public TypeVehicule() {
    }

    public int getCodeType() {
        return codeType;
    }

    public String getNomType() {
        return nomType;
    }

    public float getTelf() {
        return telf;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public void setTelf(float telf) {
        this.telf = telf;
    }
}
