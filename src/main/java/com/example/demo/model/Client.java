package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Client
{
    @Id
    private int codeClient;
    private String nomClient;
    private String addresseClient;
    private String telClient;
    private String mailClient;

    public Client() {
    }

    public Client(int codeClient, String nomClient, String addresseClient, String telClient, String mailClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.addresseClient = addresseClient;
        this.telClient = telClient;
        this.mailClient = mailClient;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getAddresseClient() {
        return addresseClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public String getMailClient() {
        return mailClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setAddresseClient(String addresseClient) {
        this.addresseClient = addresseClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }
}
