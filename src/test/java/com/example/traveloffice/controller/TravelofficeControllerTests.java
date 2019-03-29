package com.example.traveloffice.controller;

import com.example.traveloffice.services.TravelOfficeService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelofficeControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    TravelOfficeService travelOfficeService;

    String customerName = "Gosia Topij";
    String street = "Opolska";
    String zip = "42-400";
    String city = "Kato";

    @Test
    public void addCustomer() throws Exception {
        JSONObject customer = new JSONObject();
        JSONObject address = new JSONObject();
        address.put("street", street);
        address.put("zip", zip);
        address.put("city", city);
        customer.put("name", customerName);
        customer.put("trip", null);
        customer.put("address", address);

        mockMvc.perform(post("/add-customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(customer)))
                .andExpect(status().isOk())
                .andExpect(content().json(customer.toString()));
    }

    @Test
    public void addAbroadTrip() throws Exception {
        JSONObject abroadTrip = new JSONObject();

        abroadTrip.put("start", "2010-05-05");
        abroadTrip.put("end", "2010-05-05");
        abroadTrip.put("destination", "Paryz");
        abroadTrip.put("price", 5000);
        abroadTrip.put("insurance", 500);

        JSONObject calculatedTrip = new JSONObject();
        calculatedTrip = abroadTrip;
        calculatedTrip.remove("insurance");
        calculatedTrip.put("price", 5500);

        mockMvc.perform(post("/add-trip/abroad/Paryz")
                .contentType(MediaType.APPLICATION_JSON)
                .content(abroadTrip.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(calculatedTrip.toString()));
    }

    @Test
    public void addDomesticTrip() throws Exception {
        JSONObject domesticTrip = new JSONObject();

        domesticTrip.put("start", "2010-05-05");
        domesticTrip.put("end", "2010-05-05");
        domesticTrip.put("destination", "Paryz");
        domesticTrip.put("price", 4000);
        domesticTrip.put("discount", 100);

        JSONObject calculatedTrip = new JSONObject();
        calculatedTrip = domesticTrip;
        calculatedTrip.remove("discount");
        calculatedTrip.put("price", 900);

        mockMvc.perform(post("/add-trip/domestic/Paryz")
                .contentType(MediaType.APPLICATION_JSON)
                .content(domesticTrip.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(calculatedTrip.toString()));
    }

    @Test
    public void allCustomer() throws Exception {
        JSONObject customer = new JSONObject();
        JSONObject customer2 = new JSONObject();
        JSONObject address = new JSONObject();
        address.put("street", street);
        address.put("zip", zip);
        address.put("city", city);

        customer.put("name", customerName);
        customer.put("trip", null);
        customer.put("address", address);
        customer.put("name", "Macius");
        customer2.put("trip", null);
        customer2.put("address", address);

        mockMvc.perform(get("/all-customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(customer) + String.valueOf(customer2)))
                .andExpect(status().isOk());
    }
}


