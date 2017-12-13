package com.example.demo.controller;


import com.example.demo.model.Compte;
import com.example.demo.repository.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/compte")
public class CompteController {

    private CompteRepository compteRepository;

    public CompteController(CompteRepository adminRepository) {
        super();
        this.compteRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Compte> getAll(){
        List<Compte> comptes = this.compteRepository.findAll();
        return comptes;
    }

    @PutMapping
    public void insert(@RequestBody Compte compte) {
        this.compteRepository.insert(compte);
    }

    @PostMapping
    public void update(@RequestBody Compte compte) {
        this.compteRepository.save(compte);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.compteRepository.delete(id);
    }


}
