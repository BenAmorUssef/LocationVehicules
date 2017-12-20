package com.example.demo.controller;


import com.example.demo.model.Administrateur;
import com.example.demo.model.Compte;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CompteRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AdminController {

    private AdminRepository administrateurRepository;
    @Autowired
    private CounterService counterScervice;
    @Autowired
    private CompteRepository compteRepository;

    public AdminController(AdminRepository adminRepository) {
        super();
        this.administrateurRepository = adminRepository;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Administrateur> getAll(){
        List<Administrateur> administrateurs = this.administrateurRepository.findAll();
        return administrateurs;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Administrateur getWithId(@PathVariable("id") int id){
        Administrateur admin= this.administrateurRepository.findByCodeAdmin(id);
        return admin;
    }

    @CrossOrigin
    @PutMapping
    public Map<String, Object> insert(@RequestBody Administrateur admnistrateur) {
        Administrateur admin = new Administrateur();
        admin.setCodeAdmin(counterScervice.getNextSequence("admin"));
        admin.setAddressAdmin(admnistrateur.getAddressAdmin());
        admin.setMailAdmin(admnistrateur.getMailAdmin());
        admin.setTypeAdmin(admnistrateur.getTypeAdmin());
        admin.setCodeCompte(admnistrateur.getCodeCompte());
        admin.setNomAdmin(admnistrateur.getNomAdmin());
        admin.setReservations(admnistrateur.getReservations());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.administrateurRepository.insert(admin));
            response.put("count", this.administrateurRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }
    @CrossOrigin
    @PostMapping("/{id}")
    public Map<String, Object> update(@PathVariable("id") int id, @RequestBody Administrateur admnistrateur) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.administrateurRepository.save(admnistrateur));
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }
    @CrossOrigin
    @PostMapping("/login")
    public Map<String, Object> login(@Param("login") String login, @Param("passsword") String password) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();

        Compte compte = this.compteRepository.findByLoginAndMotDePasse(login, password);

        if (compte != null){
            response.put("success", "true");
            Administrateur admin = this.administrateurRepository.findByCodeCompte(compte);
            response.put("object", admin);
        }else{
            response.put("success", "false");
        }
        return response;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") int id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            this.administrateurRepository.delete(this.administrateurRepository.findByCodeAdmin(id));
            response.put("count", this.administrateurRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
