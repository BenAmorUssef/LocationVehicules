package com.example.demo.controller;


import com.example.demo.model.TypeVehicule;
import com.example.demo.repository.TypeVehiculeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/typevehicule")
public class TypeVehiculeController {

    private TypeVehiculeRepository typeVehiculeRepository;

    public TypeVehiculeController(TypeVehiculeRepository typeVehiculeRepository) {
        super();
        this.typeVehiculeRepository = typeVehiculeRepository;
    }

    @GetMapping("/all")
    public List<TypeVehicule> getAll(){
        List<TypeVehicule> reservations = this.typeVehiculeRepository.findAll();
        return reservations;
    }

    @PutMapping
    public void insert(@RequestBody TypeVehicule typeVehicule) {
        this.typeVehiculeRepository.insert(typeVehicule);
    }

    @PostMapping
    public void update(@RequestBody TypeVehicule typeVehicule) {
        this.typeVehiculeRepository.save(typeVehicule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.typeVehiculeRepository.delete(id);
    }


}
