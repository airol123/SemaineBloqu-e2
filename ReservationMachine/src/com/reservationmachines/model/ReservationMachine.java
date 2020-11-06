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

	// Revoie le nom de la machine qui correspond � la r�servation
	public String getNomMachine() {
		return this.machine.getNomMachine();
	}
	// Revoie l'�tat de la machine courante
	public String getEtatMachine() {
		return this.machine.getEtatMachine();
	}
	// Renvoie le nom de l'�tudiant concern� par la r�servation
	public String getNomEtudiant() {
		return this.etudiant.getNom();
	}
	// Renvoie le pr�nom de l'�tudiant concern� par la r�servation
	public String getPrenomEtudiant() {
		return this.etudiant.getPrenom();
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public Machine getMachine() {
		return machine;
	}

	public Timestamp getHeureDebut() {
		return heureDebut;
	}

	public Timestamp getHeureFin() {
		return heureFin;
	}
}