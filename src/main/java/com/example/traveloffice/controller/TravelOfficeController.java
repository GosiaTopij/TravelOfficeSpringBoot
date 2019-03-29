package com.example.traveloffice.controller;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.*;
import com.example.traveloffice.services.TravelOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Trip addAbroadTrip(@RequestBody AbroadTrip trip, @PathVariable(value = "destination") String destination) {
        travelOfficeService.addTrip(destination, trip);
        return trip;
    }

    @PostMapping(value = "/add-trip/domestic/{destination}", consumes = "application/json", produces = "application/json")
    public Trip addDomesticTrip(@RequestBody DomesticTrip trip, @PathVariable(value = "destination") String destination) {
        travelOfficeService.addTrip(destination, trip);
        return trip;
    }

    @GetMapping("/remove-customer/{name}")
    public ResponseEntity<Void> removeCustomer(@PathVariable(value = "name") String name) throws NoSuchCustomerException {
        Customer customer = null;
        customer = travelOfficeService.findCustomerByName(name);
        travelOfficeService.removeCustomer(customer);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/assign")
    public void assign(@RequestParam String name, @RequestParam String id) {
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

    @GetMapping("/remove-trip/{destination}")
    public String removeTrip(@PathVariable(required = true) String destination) throws NoSuchTripException {
        travelOfficeService.removeTrip(destination);
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
