package com.reservationmachines.model;

public class Utilisateur {
	private String identifiant;
	private String mdp;
	private String nom;
	private String prenom;


	public Utilisateur() {

	}

	public Utilisateur(String identifiant, String mdp) {
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	public Utilisateur(String identifiant, String mdp, String nom, String prenom) {
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;

	}
}