package com.reservationmachines.model;

public class Machine {
	private String nomMachine;
	private EtatMachine etatMachine;
	
	public Machine(String nomMachine, EtatMachine etatMachine) {
		this.nomMachine = nomMachine;
		this.etatMachine = etatMachine;
	}

	public String getNomMachine() {
		return this.nomMachine;
	}

	public String getEtatMachine() {
		return this.etatMachine.toString();
	}
}
