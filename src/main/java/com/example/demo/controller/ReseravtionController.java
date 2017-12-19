package com.example.demo.controller;


import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/reservation")
public class ReseravtionController {

    private ReservationRepository reservationRepository;
    @Autowired
    private CounterService counterScervice;

    public ReseravtionController(ReservationRepository adminRepository) {
        super();
        this.reservationRepository = adminRepository;
    }

    @GetMapping("/all")
    public List<Reservation> getAll(){
        List<Reservation> reservations = this.reservationRepository.findAll();
        return reservations;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Reservation getWithId(@PathVariable("id") int id){
        Reservation reservation = this.reservationRepository.findOne(id+"");
        return reservation;
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
    public Map<String, Object> insert(@RequestBody Reservation reservation) {
        Reservation reservation1 = new Reservation();
        reservation1.setCodeRes(counterScervice.getNextSequence("reservation"));
        reservation1.setClient(reservation.getClient());
        reservation1.setCommentaire(reservation.getCommentaire());
        reservation1.setDateArrivee(reservation.getDateArrivee());
        reservation1.setDestination(reservation.getDestination());
        reservation1.setHeureDArrivee(reservation.getHeureDArrivee());
        reservation1.setNbrVoyageur(reservation.getNbrVoyageur());
        reservation1.setStatRes(reservation.getStatRes());
        reservation1.setVehicule(reservation.getVehicule());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.reservationRepository.insert(reservation1));
            response.put("count", this.reservationRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }

    @PostMapping
    public Map<String, Object> update(@RequestBody Reservation reservation) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            response.put("object", this.reservationRepository.save(reservation));
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
            this.reservationRepository.delete(id);
            response.put("count", this.reservationRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
