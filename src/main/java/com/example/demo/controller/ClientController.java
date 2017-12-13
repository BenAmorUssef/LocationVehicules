package com.example.demo.controller;


import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository adminRepository) {
        super();
        this.clientRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Client> getAll(){
        List<Client> clients = this.clientRepository.findAll();
        return clients;
    }

    @PutMapping
    public void insert(@RequestBody Client client) {
        this.clientRepository.insert(client);
    }

    @PostMapping
    public void update(@RequestBody Client client) {
        this.clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.clientRepository.delete(id);
    }


}
