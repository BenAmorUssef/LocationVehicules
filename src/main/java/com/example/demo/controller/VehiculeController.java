package com.example.demo.controller;


import com.example.demo.model.Vehicule;
import com.example.demo.repository.VehiculeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    private VehiculeRepository vehiculeRepository;

    public VehiculeController(VehiculeRepository adminRepository) {
        super();
        this.vehiculeRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Vehicule> getAll(){
        List<Vehicule> vehicules = this.vehiculeRepository.findAll();
        return vehicules;
    }

    @GetMapping("/all/localite/{id}")
    public List<Vehicule> getAllByLocalite(@PathVariable("id") int id){
        List<Vehicule> vehicules = this.vehiculeRepository.findAllByLocalite_CodeLocal(id);
        return vehicules;
    }

    @GetMapping("/all/type/{id}")
    public List<Vehicule> getAllByType(@PathVariable("id") int id){
        List<Vehicule> vehicules = this.vehiculeRepository.findAllByTypeVehicule_CodeType(id);
        return vehicules;
    }

    @PutMapping
    public void insert(@RequestBody Vehicule vehicule) {
        this.vehiculeRepository.insert(vehicule);
    }

    @PostMapping
    public void update(@RequestBody Vehicule vehicule) {
        this.vehiculeRepository.save(vehicule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.vehiculeRepository.delete(id);
    }


}
