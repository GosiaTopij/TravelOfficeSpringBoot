package com.example.traveloffice.services;

import com.example.traveloffice.exceptions.NoSuchCustomerException;
import com.example.traveloffice.exceptions.NoSuchTripException;
import com.example.traveloffice.modal.AbroadTrip;
import com.example.traveloffice.modal.Customer;
import com.example.traveloffice.modal.Trip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelOfficeServiceTest {

    @Autowired
    TravelOfficeService travelOfficeService;

    @Test
    public void addCustomer() {
        int a = travelOfficeService.getCustomerCount();
        Customer c = new Customer("Maks");
        travelOfficeService.addCustomer(c);
        assertEquals(a + 1, travelOfficeService.getCustomerCount());
    }

    @Test
    public void addTrip() {
        int a = travelOfficeService.getTripCount();
        Trip trip = new AbroadTrip(LocalDate.of(2000, 05, 20), LocalDate.of(2001, 05, 20), "Paryż");
        travelOfficeService.addTrip("1", trip);
        assertEquals(a + 1, travelOfficeService.getTripCount());
    }

    @Test
    public void findCustomerByName() throws NoSuchCustomerException {
        String name = "Gosia";
        Customer expected = new Customer(name);
        travelOfficeService.addCustomer(expected);
        Customer result = travelOfficeService.findCustomerByName(name);
        assertEquals(expected, result);
    }

    @Test(expected = NoSuchCustomerException.class)
    public void exceptionWhenFindCustomerWhichDoesNotExist() throws NoSuchCustomerException {
        travelOfficeService.findCustomerByName("Dominik Kwiat");
    }

    @Test(expected = NoSuchTripException.class)
    public void exceptionWhenRemoveTripWhichDoesNotExist() throws NoSuchTripException {
        travelOfficeService.removeTrip("Lalaland");
    }

    @Test(expected = NoSuchCustomerException.class)
    public void exceptionWhenRemoveCustomerWhichDoesNotExist() throws NoSuchCustomerException {
        Customer c = new Customer("Dominik Kwiat");
        travelOfficeService.removeCustomer(c);
    }

    @Test(expected = NoSuchTripException.class)
    public void exceptionWhenFindTripWhichDoesNotExist() throws NoSuchTripException {
        travelOfficeService.findTripByDestination("Lalaland");
    }
}