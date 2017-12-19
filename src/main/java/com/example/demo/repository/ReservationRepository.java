package com.example.demo.repository;

import com.example.demo.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    public Reservation findByCodeRes(int code);
    List<Reservation> findAllByClient_CodeClient(int client);
    List<Reservation> findAllByVehicule_Matricule(String code);
    List<Reservation> findAllByOrderByVehicule(String code);

}
