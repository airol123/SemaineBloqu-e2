package com.reservationmachines.model;

public class Reclamation {
    private Enum type;
    private String description;
    private ReservationMachine rm;

    public Reclamation() {
    }

    public Reclamation(Enum type, String description, ReservationMachine rm) {
        this.type = type;
        this.description = description;
        this.rm = rm;
    }
}
