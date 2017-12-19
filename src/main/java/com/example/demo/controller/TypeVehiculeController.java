package com.example.demo.controller;


import com.example.demo.model.TypeVehicule;
import com.example.demo.repository.TypeVehiculeRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/typevehicule")
public class TypeVehiculeController {

    private TypeVehiculeRepository typeVehiculeRepository;
    @Autowired
    private CounterService counterScervice;

    public TypeVehiculeController(TypeVehiculeRepository typeVehiculeRepository) {
        super();
        this.typeVehiculeRepository = typeVehiculeRepository;
    }

    @GetMapping("/all")
    public List<TypeVehicule> getAll(){
        List<TypeVehicule> reservations = this.typeVehiculeRepository.findAll();
        return reservations;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public TypeVehicule getWithId(@PathVariable("id") int id){
        TypeVehicule typeVehicule = this.typeVehiculeRepository.findOne(id+"");
        return typeVehicule;
    }
    @PutMapping
    public Map<String, Object> insert(@RequestBody TypeVehicule typeVehicule) {
        TypeVehicule typeVehicule1 = new TypeVehicule();
        typeVehicule1.setCodeType(counterScervice.getNextSequence("type"));
        typeVehicule1.setNomType(typeVehicule.getNomType());
        typeVehicule1.setTelf(typeVehicule.getTelf());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.typeVehiculeRepository.insert(typeVehicule1));
            response.put("count", this.typeVehiculeRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @PostMapping
    public Map<String, Object> update(@RequestBody TypeVehicule typeVehicule) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.typeVehiculeRepository.save(typeVehicule));
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
            this.typeVehiculeRepository.delete(id);
            response.put("count", this.typeVehiculeRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;

    }


}
