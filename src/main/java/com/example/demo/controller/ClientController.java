package com.example.demo.controller;


import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClientController {

    private ClientRepository clientRepository;
    @Autowired
    private CounterService counterScervice;

    public ClientController(ClientRepository adminRepository) {
        super();
        this.clientRepository = adminRepository;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Client> getAll(){
        List<Client> clients = this.clientRepository.findAll();
        return clients;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Client getWithId(@PathVariable("id") int id){
        Client client= this.clientRepository.findByCodeClient(id);
        return client;
    }
    @CrossOrigin
    @PutMapping
    public Map<String, Object> insert(@RequestBody Client client) {
        Client client1 = new Client();
        client1.setCodeClient(counterScervice.getNextSequence("client"));
        client1.setAddresseClient(client.getAddresseClient());
        client1.setMailClient(client.getMailClient());
        client1.setNomClient(client.getNomClient());
        client1.setTelClient(client.getTelClient());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.clientRepository.insert(client1));
            response.put("count", this.clientRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @CrossOrigin
    @PostMapping
    public Map<String, Object> update(@RequestBody Client client) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.clientRepository.save(client));
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;

    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") int id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            this.clientRepository.delete(this.clientRepository.findByCodeClient(id));
            response.put("count", this.clientRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
