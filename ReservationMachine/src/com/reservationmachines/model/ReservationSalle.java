package com.reservationmachines.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationSalle extends Reservation {
	private String nomCours;
	private ResponsableTP responsableTP;
	private Salle salle;
	private GroupeTP groupeTP;
	private Date date;
	private Timestamp heureDebut;
	private Timestamp heureFin;
	private String formation;
	
	public ReservationSalle(String nomCours, ResponsableTP responsableTP, Salle salle, GroupeTP groupeTP, String formation, Date date, Timestamp heureDebut, Timestamp heureFin) {
		this.formation = formation;
		this.nomCours = nomCours;
		this.responsableTP = responsableTP;
		this.salle = salle;
		this.groupeTP = groupeTP;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	public String getNomCours() {
		return nomCours;
	}
	public ResponsableTP getResponsableTP() {
		return responsableTP;
	}
	public Salle getSalle() {
		return salle;
	}
	public String getNomGroupeTP() {
		return groupeTP.getNomGroupe();
	}
	public String getDate() {
		return date.toString();
	}
	public String getHeureDebut() {
		return heureDebut.toString().substring(11, 16);
	}
	public String getHeureFin() {
		return heureFin.toString().substring(11, 16);
	}	
	public String getNomSalle() {
		return this.getSalle().getNomSalle();
	}
	public String getNomFormation() {
		return this.formation.toString();
	}
	public String getCapacite() {
		return String.valueOf(this.salle.getCapacite());
	}
}