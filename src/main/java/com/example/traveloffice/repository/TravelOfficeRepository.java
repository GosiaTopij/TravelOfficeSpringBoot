package com.example.traveloffice.repository;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.Customer;
import com.example.traveloffice.modal.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface TravelOfficeRepository {
    Customer findCustomerByName(String name) throws NoSuchCustomerException;
    void findTripByDestination(String destination) throws NoSuchTripException;
}
