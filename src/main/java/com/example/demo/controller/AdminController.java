package com.example.demo.controller;


import com.example.demo.model.Administrateur;
import com.example.demo.model.Reservation;
import com.example.demo.repository.AdminRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminRepository administrateurRepository;

    public AdminController(AdminRepository adminRepository) {
        super();
        this.administrateurRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Administrateur> getAll(){
        List<Administrateur> administrateurs = this.administrateurRepository.findAll();
        return administrateurs;
    }

    @PutMapping
    public void insert(@RequestBody Administrateur admnistrateur) {
        this.administrateurRepository.insert(admnistrateur);
    }

    @PostMapping
    public void update(@RequestBody Administrateur admnistrateur) {
        this.administrateurRepository.save(admnistrateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.administrateurRepository.delete(id);
    }


}
