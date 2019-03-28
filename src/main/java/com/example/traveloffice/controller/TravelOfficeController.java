package com.example.traveloffice.controller;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.*;
import com.example.traveloffice.services.TravelOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@RestController
public class TravelOfficeController {

    @Autowired
    private TravelOfficeService travelOfficeService;


    @PostMapping(value = "/add-customer", consumes = "application/json", produces = "application/json")
    public Customer addCustomer(@RequestBody Customer customer) {
        travelOfficeService.addCustomer(customer);
        return customer;
    }

    @PostMapping(value = "/add-trip/abroad/{destination}", consumes = "application/json", produces = "application/json")
    public Trip addAbroadTrip(@Valid @RequestBody AbroadTrip trip, @PathVariable String destination) {
           travelOfficeService.addTrip(destination,trip);
           return trip;
    }

    @PostMapping(value = "/add-trip/domestic/{destination}", consumes = "application/json", produces = "application/json")
    public Trip addDomesticTrip(@RequestBody DomesticTrip trip, @PathVariable String destination) {
        travelOfficeService.addTrip(destination,trip);
        return trip;
    }

//    @GetMapping("/add-trip")
//    public Trip addTrip(@RequestParam String id, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String destination, @RequestParam double price, @RequestParam String type, @RequestParam double discount,@RequestParam double insurance) {
//
//        if (type.toLowerCase().equals("krajowy")) {
//            Trip domesticTrip = new DomesticTrip(LocalDate.parse(startDate), LocalDate.parse(endDate), destination);
//            domesticTrip.setPrice(price);
//            ((DomesticTrip) domesticTrip).setOwnArrivalDiscount(discount);
//            travelOfficeService.addTrip(id, domesticTrip);
//            return domesticTrip;
//        } else if (type.toLowerCase().equals("zagraniczny")) {
//            Trip abroadTrip = new AbroadTrip(LocalDate.parse(startDate), LocalDate.parse(endDate), destination);
//            abroadTrip.setPrice(price);
//            ((AbroadTrip) abroadTrip).setInsurance(insurance);
//            travelOfficeService.addTrip(id, abroadTrip);
//            return abroadTrip;
//        } else {
//            System.out.println("Niepoprawny typ podróży");
//        }
//        return null;
//    }

    @GetMapping("/remove-customer")
    public String removeCustomer(@RequestParam String firstName, @RequestParam String lastName) throws NoSuchCustomerException {
        String name = firstName + " " + lastName;
        Customer customer = null;
        customer = travelOfficeService.findCustomerByName(name);
        travelOfficeService.removeCustomer(customer);
        return "Usunięto klienta";
    }

    @GetMapping("/assign")
    public void assign(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String id) {
        String name = firstName + " " + lastName;
        Customer customer = null;
        try {
            customer = travelOfficeService.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            e.printStackTrace();
        }

        Trip trip = travelOfficeService.getTrips().get(id);

        if (trip == null) System.out.println("Brak wycieczki z id: " + id);
        else {
            customer.assignTrip(trip);
            System.out.println("Dodano wycieczke do klienta.");
        }
    }

    @GetMapping("/remove-trip")
    public String removeTrip(@RequestParam String id) throws NoSuchTripException {
        travelOfficeService.removeTrip(id);
        return "Usunieto wycieczke";
    }

    @GetMapping("/all-trips")
    public Map<String, Trip> allTrips() {
        return travelOfficeService.getTrips();
    }

    @GetMapping("/all-customers")
    public Set<Customer> allCustomers() {
        return travelOfficeService.getCustomers();
    }
}
