package com.reservationmachines.model;

import java.sql.Timestamp;

public class ReservationMachine extends Reservation {

	private Etudiant etudiant;
	private Machine machine;
	private Timestamp heureDebut;
	private Timestamp heureFin;
	
	public ReservationMachine(Etudiant etudiant, Machine machine,
		Timestamp heureDebut, Timestamp heureFin) {
		this.etudiant = etudiant;
		this.machine = machine;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	// Revoie le nom de la machine qui correspond à la réservation
	public String getNomMachine() {
		return this.machine.getNomMachine();
	}
	// Revoie l'état de la machine courante
	public String getEtatMachine() {
		return this.machine.getEtatMachine();
	}
	// Renvoie le nom de l'étudiant concerné par la réservation
	public String getNomEtudiant() {
		return this.etudiant.getNom();
	}
	// Renvoie le prénom de l'étudiant concerné par la réservation
	public String getPrenomEtudiant() {
		return this.etudiant.getPrenom();
	}
}