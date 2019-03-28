package com.example.traveloffice.modal;
import java.time.LocalDate;

public abstract class Trip {

    private LocalDate start;
    private LocalDate end;
    private String destination;
    private double price;

    public Trip() {
    }

    public Trip(LocalDate start, LocalDate end, String destination) {
        this.start = start;
        this.end = end;
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


}
