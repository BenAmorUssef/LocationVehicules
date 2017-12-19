package com.example.demo.controller;


import com.example.demo.model.Localite;
import com.example.demo.repository.LocaliteRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/localite")
public class LocaliteController {

    private LocaliteRepository localiteRepository;
    @Autowired
    private CounterService counterScervice;

    public LocaliteController(LocaliteRepository adminRepository) {
        super();
        this.localiteRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Localite> getAll(){
        List<Localite> localites = this.localiteRepository.findAll();
        return localites;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Localite getWithId(@PathVariable("id") int id){
        Localite localite= this.localiteRepository.findOne(id+"");
        return localite;
    }


    @PutMapping
    public Map<String, Object> insert(@RequestBody Localite localite) {
        Localite localite1 = new Localite();
        localite1.setCodeLocal(counterScervice.getNextSequence("localite"));
        localite1.setNomLocal(localite.getNomLocal());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.localiteRepository.insert(localite1));
            response.put("count", this.localiteRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @PostMapping
    public Map<String, Object> update(@RequestBody Localite localite) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.localiteRepository.save(localite));
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
            this.localiteRepository.delete(id);
            response.put("count", this.localiteRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
