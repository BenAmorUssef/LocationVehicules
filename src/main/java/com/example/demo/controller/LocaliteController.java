package com.example.demo.controller;


import com.example.demo.model.Localite;
import com.example.demo.repository.LocaliteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/localite")
public class LocaliteController {

    private LocaliteRepository localiteRepository;

    public LocaliteController(LocaliteRepository adminRepository) {
        super();
        this.localiteRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Localite> getAll(){
        List<Localite> localites = this.localiteRepository.findAll();
        return localites;
    }

    @PutMapping
    public void insert(@RequestBody Localite localite) {
        this.localiteRepository.insert(localite);
    }

    @PostMapping
    public void update(@RequestBody Localite localite) {
        this.localiteRepository.save(localite);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.localiteRepository.delete(id);
    }


}
