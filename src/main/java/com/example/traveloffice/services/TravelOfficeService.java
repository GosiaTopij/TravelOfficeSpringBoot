package com.example.traveloffice.services;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.Customer;
import com.example.traveloffice.modal.Trip;
import com.example.traveloffice.repository.TravelOfficeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
