package com.reservationmachines.model;

public class Machine {
	private String nomMachine;
	private EtatMachine etatMachine;
	private Salle salle; ///!!!



	public Machine(String nomMachine, EtatMachine etatMachine,Salle salle) {
		this.nomMachine = nomMachine;
		this.etatMachine = etatMachine;
		this.salle=salle;
	}

	public Salle getSalle() {
		return salle;
	}

	public String getNomMachine() {
		return this.nomMachine;
	}

	public String getEtatMachine() {
		return this.etatMachine.toString();
	}
}
