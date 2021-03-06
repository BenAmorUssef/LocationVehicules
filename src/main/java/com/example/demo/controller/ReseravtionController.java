package com.example.demo.controller;


import com.example.demo.model.Client;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.CounterService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.model.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.util.CloseableIterator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.AggregationOptions.OutputMode.CURSOR;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ReseravtionController {

    private ReservationRepository reservationRepository;
    @Autowired
    private CounterService counterScervice;
    @Autowired
    private MongoTemplate mongoTemplate;

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
        Reservation reservation = this.reservationRepository.findByCodeRes(id);
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


    @GetMapping("/max")
    public List<Client> getAllbvss() {
        List<Client> clients = null;
        try {


            AggregationOptions options = new AggregationOptions.Builder().cursor(new BasicDBObject()).build();

            Aggregation aggregation = newAggregation(
                    project("client"),
                    unwind("client"),
                    group("client")
                            .count().as("count")
            ).withOptions(options);

            AggregationResults<Reservation> results = mongoTemplate.aggregate(aggregation, "reservation", Reservation.class);


            List<Reservation> ress = results.getMappedResults();

            clients = new ArrayList<>();
            for (int i = 0; i < ress.size(); i++) {
                clients.add(ress.get(i).getClient());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;

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
    public Map<String, Object> delete(@PathVariable("id") int id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            response.put("status", "true");
            this.reservationRepository.delete(this.reservationRepository.findByCodeRes(id));
            response.put("count", this.reservationRepository.count());
        }catch (Exception e){
            response.put("status", "false");
            response.put("error", e.getMessage());
        }
        return response;
    }


}
