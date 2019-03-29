package com.example.traveloffice.repository;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.Customer;
import com.example.traveloffice.modal.Trip;

import java.util.Map;
import java.util.Set;

public interface TravelOfficeRepository {
    void addCustomer(Customer customer);

    void addTrip(String id, Trip trip);

    boolean removeTrip(String id) throws NoSuchTripException;

    boolean removeCustomer(Customer c) throws NoSuchCustomerException;

    Customer findCustomerByName(String name) throws NoSuchCustomerException;

    void findTripByDestination(String destination) throws NoSuchTripException;

    Set<Customer> getCustomers();

    Map<String, Trip> getTrips();
}
