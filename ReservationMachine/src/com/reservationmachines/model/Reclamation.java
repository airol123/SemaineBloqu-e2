package com.reservationmachines.model;

public class Reclamation {
    private TypeReclamation type;
    private String description;
    private ReservationMachine rm;

    public Reclamation() {
    }

    public Reclamation(TypeReclamation type, String description, ReservationMachine rm) {
        this.type = type;
        this.description = description;
        this.rm = rm;
    }

	public TypeReclamation getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public ReservationMachine getRm() {
		return rm;
	}
}
