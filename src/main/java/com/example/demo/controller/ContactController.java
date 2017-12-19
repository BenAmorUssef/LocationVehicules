package com.example.demo.controller;


import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ContactController {

    private ContactRepository contactRepository;
    @Autowired
    private CounterService counterScervice;

    public ContactController(ContactRepository contactRepository) {
        super();
        this.contactRepository = contactRepository;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Contact> getAll(){
        List<Contact> contacts = this.contactRepository.findAll();
        return contacts;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Contact getWithId(@PathVariable("id") int id){
        Contact contact= this.contactRepository.findById(id);
        return contact;
    }
    @CrossOrigin
    @PutMapping
    public Map<String, Object> insert(@RequestBody Contact client) {
        Contact contact1 = new Contact();
        contact1.setId(counterScervice.getNextSequence("contact"));
        contact1.setNom(client.getNom());
        contact1.setEmail(client.getEmail());
        contact1.setMessage(client.getMessage());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.contactRepository.insert(contact1));
            response.put("count", this.contactRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @CrossOrigin
    @PostMapping
    public Map<String, Object> update(@RequestBody Contact client) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.contactRepository.save(client));
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;

    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") int id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            this.contactRepository.delete(this.contactRepository.findById(id));
            response.put("count", this.contactRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
