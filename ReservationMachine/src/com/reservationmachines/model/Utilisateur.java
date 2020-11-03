package com.reservationmachines.model;

public abstract class Utilisateur {
	protected String identifiant;
	protected String mdp;
	protected String email;
	protected String nom;
	protected String prenom;

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

	public Utilisateur(String identifiant, String mdp, String nom, String prenom, String email) {
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;

	}
}