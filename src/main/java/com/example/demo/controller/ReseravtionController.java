package com.example.demo.controller;


import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservation")
public class ReseravtionController {

    private ReservationRepository reservationRepository;

    public ReseravtionController(ReservationRepository adminRepository) {
        super();
        this.reservationRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Reservation> getAll(){
        List<Reservation> reservations = this.reservationRepository.findAll();
        return reservations;
    }

    @GetMapping("all/client/{id}")
    public List<Reservation> getAllbc(@PathVariable("id") int id){
        List<Reservation> reservations = this.reservationRepository.findAllByClient_CodeClient(id);
        return reservations;
    }

    @GetMapping("all/vehicule/{id}")
    public List<Reservation> getAllbv(@PathVariable("id") String id){
        List<Reservation> reservations = this.reservationRepository.findAllByVehicule_Matricule(id);
        return reservations;
    }

    @PutMapping
    public void insert(@RequestBody Reservation reservation) {
        this.reservationRepository.insert(reservation);
    }

    @PostMapping
    public void update(@RequestBody Reservation reservation) {
        this.reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.reservationRepository.delete(id);
    }


}
