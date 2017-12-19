package com.example.demo.controller;


import com.example.demo.model.Vehicule;
import com.example.demo.repository.VehiculeRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    private VehiculeRepository vehiculeRepository;
    @Autowired
    private CounterService counterScervice;

    public VehiculeController(VehiculeRepository adminRepository) {
        super();
        this.vehiculeRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Vehicule> getAll(){
        List<Vehicule> vehicules = this.vehiculeRepository.findAll();
        return vehicules;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Vehicule getWithId(@PathVariable("id") int id){
        Vehicule vehicule = this.vehiculeRepository.findOne(id+"");
        return vehicule;
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
    public Map<String, Object> insert(@RequestBody Vehicule vehicule) {
        Vehicule vehicule1 = new Vehicule();
        vehicule1.setMatricule(counterScervice.getNextSequence("vehicule")+"");
        vehicule1.setLocalite(vehicule.getLocalite());
        vehicule1.setMarqueVeh(vehicule.getMarqueVeh());
        vehicule1.setNombrePlace(vehicule.getNombrePlace());
        vehicule1.setPuissanceVeh(vehicule.getPuissanceVeh());
        vehicule1.setTypeVehicule(vehicule.getTypeVehicule());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.vehiculeRepository.insert(vehicule1));
            response.put("count", this.vehiculeRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @PostMapping
    public Map<String, Object> update(@RequestBody Vehicule vehicule) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.vehiculeRepository.save(vehicule));
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
            this.vehiculeRepository.delete(id);
            response.put("count", this.vehiculeRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;

    }


}
