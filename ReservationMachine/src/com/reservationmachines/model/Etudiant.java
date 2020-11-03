package com.reservationmachines.model;

public class Etudiant extends Utilisateur {

	public Etudiant(String numEtudiant, String mdp, String email, String nom, String prenom) {
		this.identifiant = numEtudiant;
		this.mdp = mdp;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

}
