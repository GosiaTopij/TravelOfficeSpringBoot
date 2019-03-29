package com.example.traveloffice.modal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

@JsonDeserialize(as = DomesticTrip.class)
public class DomesticTrip extends Trip {
    private double ownArrivalDiscount;

    public DomesticTrip() {
    }

    public DomesticTrip(LocalDate start, LocalDate end, String destination) {
        super(start, end, destination);
    }

    public double getOwnArrivalDiscount() {
        return ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() - ownArrivalDiscount;
    }

}
