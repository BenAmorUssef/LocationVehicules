package com.example.demo.seeder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner{
    private AdminRepository adminRepository;
    private ClientRepository clientRepository;
    private CompteRepository compteRepository;
    private LocaliteRepository localiteRepository;
    private ReservationRepository reservationRepository;
    private VehiculeRepository vehiculeRepository;
    private TypeVehiculeRepository typeVehiculeRepository;

    public Seeder(
            AdminRepository adminRepository,
            ClientRepository clientRepository,
            CompteRepository compteRepository,
            LocaliteRepository localiteRepository,
            ReservationRepository reservationRepository,
            VehiculeRepository vehiculeRepository,
            TypeVehiculeRepository typeVehiculeRepository) {
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
        this.localiteRepository = localiteRepository;
        this.reservationRepository = reservationRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.typeVehiculeRepository = typeVehiculeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Compte aliC = new Compte( 0, "Ali", "nabeul");
        Compte medC = new Compte( 2, "med", "ariana");
        Compte salahC = new Compte( 3, "salah", "sousse");
        Compte mounaC = new Compte( 4, "mouna", "sfax");

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = null;
        try {
            startDate = df.parse("12/12/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Client aliCl = new Client( 0, "Ali", "nabeul","20202020",  "ali@email.com");
        Client ahmedCl = new Client( 1, "ahmed", "tunis", "20202020", "ali@email.com");
        Client medCl = new Client( 2, "med", "ariana","20202020",  "ali@email.com");
        Client salahCl = new Client( 3, "salah", "sousse", "20202020", "ali@email.com");
        Client mounaCl = new Client( 4, "mouna", "sfax", "20202020", "ali@email.com");

        Localite nabeul = new Localite( 0, "nabeul");
        Localite ariana = new Localite( 2,  "ariana");
        Localite sousse = new Localite( 3,  "sousse");
        Localite sfax = new Localite( 4,  "sfax");

        TypeVehicule tv = new TypeVehicule(0, "voiture", 0.0f);

        Vehicule v1 = new Vehicule("veh-1", "peugeaut", "4CH", 0,tv , nabeul );
        Vehicule v2 = new Vehicule("veh-2", "mazerrati", "5CH", 4, tv,  sousse);
        Vehicule v3 = new Vehicule("veh-3", "ferrari", "5CH", 0, tv,  nabeul);
        Vehicule v4 = new Vehicule("veh-4", "mybash", "5CH", 4, tv,  sfax);
        Vehicule v5 = new Vehicule("veh-5", "mazerrati", "5CH", 4, tv,  ariana);


        Reservation rev1 = new Reservation( 0, startDate, "en cours", "sfax", new Date(), "aucun commentaire", 4, aliCl, v1 );
        Reservation rev11 = new Reservation( 2, startDate, "en cours", "sfax", new Date(), "aucun commentaire", 4, aliCl, v1 );
        Reservation rev2 = new Reservation( 3, startDate, "en cours", "tunis", new Date(), "aucun commentaire", 2, ahmedCl, v2);
        Reservation rev22 = new Reservation( 4, startDate, "en cours", "tunis", new Date(), "aucun commentaire", 2, ahmedCl, v2);
        Reservation rev3 = new Reservation( 5, startDate, "en cours", "sousse", new Date(), "aucun commentaire", 4, medCl, v3);
        Reservation rev33 = new Reservation( 1, startDate, "en cours", "sousse", new Date(), "aucun commentaire", 4, medCl, v3);
        Reservation rev4 = new Reservation( 6, startDate, "en cours", "nabeul", new Date(), "aucun commentaire", 2, salahCl, v4);
        Reservation rev44 = new Reservation( 7, startDate, "en cours", "nabeul", new Date(), "aucun commentaire", 2, salahCl, v4);
        Reservation rev5 = new Reservation( 8, startDate, "en cours", "tatouine", new Date(), "aucun commentaire", 4, mounaCl, v5);
        Reservation rev55 = new Reservation( 9, startDate, "en cours", "tatouine", new Date(), "aucun commentaire", 4, mounaCl, v5);

        Administrateur ali = new Administrateur( 0, "Ali", "nabeul", "ali@email.com", "manager", aliC, Arrays.asList(rev1, rev11, rev22, rev2) );
        Administrateur salah = new Administrateur( 1, "salah", "tunis", "ali@email.com", "manager", salahC, Arrays.asList(rev1, rev11, rev3, rev5));
        Administrateur med = new Administrateur( 2, "med", "ariana", "ali@email.com", "manager", medC, Arrays.asList(rev4, rev11, rev5, rev55));
        Administrateur mouna = new Administrateur( 3, "mouna", "sousse", "mouna@email.com", "manager", mounaC, Arrays.asList(rev3, rev55, rev4,rev33,rev44, rev5));

        this.adminRepository.deleteAll();
        this.clientRepository.deleteAll();
        this.compteRepository.deleteAll();
        this.localiteRepository.deleteAll();
        this.vehiculeRepository.deleteAll();
        this.typeVehiculeRepository.deleteAll();
        this.reservationRepository.deleteAll();
        //add our hotels to the database

        this.clientRepository.save(Arrays.asList(aliCl, salahCl, medCl, ahmedCl, mounaCl));
        this.compteRepository.save(Arrays.asList(aliC, medC, salahC, mounaC));
        this.localiteRepository.save(Arrays.asList(nabeul, ariana, sousse, sfax ));
        this.typeVehiculeRepository.save(tv);
        this.vehiculeRepository.save(Arrays.asList(v1, v2, v3, v4, v5));
        this.reservationRepository.save(Arrays.asList(rev1, rev2, rev3, rev4, rev5, rev11, rev22, rev33, rev44, rev55));
        this.adminRepository.save(Arrays.asList(ali, salah, med, salah, mouna));

    }

}