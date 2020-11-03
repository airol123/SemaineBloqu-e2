package com.reservationmachines.model;

public abstract class Utilisateur {
	protected String identifiant;
	protected String mdp;
	protected String email;
	protected String nom;
	protected String prenom;
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

	public Utilisateur(String identifiant, String mdp, String nom, String prenom, String email) {
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;

	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}