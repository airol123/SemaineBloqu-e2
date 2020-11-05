package com.reservationmachines.model;

import java.util.ArrayList;

public class Salle {
	private String nomSalle;
	private int capacite;
//	private EtatSalle etatSalle;
	private ArrayList<Machine> machines;

	public Salle() {
	}

	public Salle(String nomSalle) {
		this.nomSalle = nomSalle;		
	}

	private void sysout() {
	// TODO Auto-generated method stub

	}

	public Salle(String nomSalle, int capacite, ArrayList<Machine> machines) {
		this.nomSalle = nomSalle;
		this.capacite = capacite;
		this.machines = machines;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public ArrayList<Machine> getMachines() {
		return machines;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public void setMachines(ArrayList<Machine> machines) {
		this.machines = machines;
	}
}
