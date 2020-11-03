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
}