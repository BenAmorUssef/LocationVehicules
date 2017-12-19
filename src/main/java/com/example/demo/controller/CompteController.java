package com.example.demo.controller;


import com.example.demo.model.Compte;
import com.example.demo.repository.CompteRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/compte")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompteController {

    private CompteRepository compteRepository;
    @Autowired
    private CounterService counterScervice;

    public CompteController(CompteRepository adminRepository) {
        super();
        this.compteRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Compte> getAll(){
        List<Compte> comptes = this.compteRepository.findAll();
        return comptes;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Compte getWithId(@PathVariable("id") int id){
        Compte compte= this.compteRepository.findOne(id+"");
        return compte;
    }
    @PutMapping
    public Map<String, Object> insert(@RequestBody Compte compte) {
        Compte compte1 = new Compte();
        compte1.setCodeCompte(counterScervice.getNextSequence("compte"));
        compte1.setLogin(compte.getLogin());
        compte1.setMotDePasse(compte.getMotDePasse());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.compteRepository.insert(compte1));
            response.put("count", this.compteRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @PostMapping
    public Map<String, Object> update(@RequestBody Compte compte) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.compteRepository.save(compte));
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") String id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            this.compteRepository.delete(id);
            response.put("count", this.compteRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
