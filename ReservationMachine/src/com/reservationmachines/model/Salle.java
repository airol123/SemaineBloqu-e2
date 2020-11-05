package com.reservationmachines.model;

import java.util.ArrayList;

public class Salle {
	private String nomSalle;
	private int capacite;
	private EtatSalle etatSalle;
	private ArrayList<Machine> machines;

	public Salle() {
	}

	public Salle(String nomSalle, int capacite) {
		this.nomSalle = nomSalle;
		this.capacite = capacite;
	}
	
	public Salle(String nomSalle, int capacite, EtatSalle etatSalle) {
		this.nomSalle = nomSalle;
		this.capacite = capacite;
		this.etatSalle = etatSalle;
	}

	private void sysout() {
	// TODO Auto-generated method stub

	}

	public Salle(String nomSalle, int capacite, EtatSalle etatSalle, ArrayList<Machine> machines) {
		this.nomSalle = nomSalle;
		this.capacite = capacite;
		this.etatSalle = etatSalle;
		this.machines = machines;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public EtatSalle getEtatSalle() {
		return etatSalle;
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

	public void setEtatSalle(EtatSalle etatSalle) {
		this.etatSalle = etatSalle;
	}

	public void setMachines(ArrayList<Machine> machines) {
		this.machines = machines;
	}
}
