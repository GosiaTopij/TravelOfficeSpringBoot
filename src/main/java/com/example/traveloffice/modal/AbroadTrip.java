package com.example.traveloffice.modal;

import java.time.LocalDate;

public class AbroadTrip extends Trip {
    private double insurance;

    public AbroadTrip(LocalDate start, LocalDate end, String destination) {
        super(start, end, destination);
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getPrice() {
        return super.getPrice() + insurance;
    }
}
