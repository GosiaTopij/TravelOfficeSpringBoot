package com.example.traveloffice.services;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.Customer;
import com.example.traveloffice.modal.Trip;
import com.example.traveloffice.repository.TravelOfficeRepository;
import com.example.traveloffice.repository.TravelOfficeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TravelOfficeService {

    private TravelOfficeRepositoryImpl travelOfficeRepositoryImpl;

    @Autowired
    public TravelOfficeService(TravelOfficeRepositoryImpl travelOfficeRepositoryImpl) {
        this.travelOfficeRepositoryImpl = travelOfficeRepositoryImpl;
    }

    public TravelOfficeService() {
    }

    public int getTripCount() {
        return travelOfficeRepositoryImpl.getTripCount();
    }

    public int getCustomerCount() {
        return travelOfficeRepositoryImpl.getCustomerCount();
    }

    public void addCustomer(Customer customer) {
        travelOfficeRepositoryImpl.addCustomer(customer);
    }

    public void getInfo() {
        travelOfficeRepositoryImpl.getInfo();
    }

    public void addTrip(String id, Trip trip) {
        travelOfficeRepositoryImpl.addTrip(id, trip);
    }

    public boolean removeTrip(String id) throws NoSuchTripException {
        return travelOfficeRepositoryImpl.removeTrip(id);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        return travelOfficeRepositoryImpl.findCustomerByName(name);
    }

    public boolean removeCustomer(Customer c) throws NoSuchCustomerException {
        return travelOfficeRepositoryImpl.removeCustomer(c);
    }

    public void findTripByDestination(String destination) throws NoSuchTripException {
        travelOfficeRepositoryImpl.findTripByDestination(destination);
    }

    public Set<Customer> getCustomers() {
        return travelOfficeRepositoryImpl.getCustomers();
    }

    public Map<String, Trip> getTrips() {
        return travelOfficeRepositoryImpl.getTrips();
    }

    //
//    public void addCustomer(Customer customer) {
//        travelOfficeRepository.save(customer);
//    }
//    public void removeCustomer(Customer customer) {
//        travelOfficeRepository.delete(customer);
//    }
//
//    public void addTrip(Trip trip) {
//        travelOfficeRepository.save(trip);
//    }
//
//    public void removeTrip(String destination) {
//        travelOfficeRepository.delete(destination);
//    }
//
//    public List<Customer> allCustomers(){
//        List<Customer> customers = new ArrayList<>();
//        for(Object customer: travelOfficeRepository.findAll()){
//            if (customer instanceof Customer){
//                customers.add((Customer) customer);
//            }
//        }
//        return customers;
//    }
//
//    public List<Trip> allTrips(){
//        List<Trip> trips = new ArrayList<>();
//        for(Object trip: travelOfficeRepository.findAll()){
//            if (trip instanceof Trip){
//                trips.add((Trip) trip);
//            }
//        }
//        return trips;
//    }
//
//    public Customer findCustomerByName(String name) {
//        return travelOfficeRepository.findCustomerByName(name);
//    }
//    public Trip findTripByDestination(String destination) {
//        return travelOfficeRepository.findTripByDestination(destination);
//    }

//    public void assign(String name){
//        Customer customer = null;
//        try {
//            customer = travelOfficeRepository.findCustomerByName(name);
//        } catch (NoSuchCustomerException e) {
//            e.printStackTrace();
//        }
//
//        Trip trip = travelOfficeRepository.getTrips().get(id);
//
//        if (trip == null) System.out.println("Brak wycieczki z id: " + id);
//        else {
//            customer.assignTrip(trip);
//        }
//
//    }


}
