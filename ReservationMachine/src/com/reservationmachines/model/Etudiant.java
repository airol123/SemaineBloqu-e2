package com.reservationmachines.model;

public class Etudiant extends Utilisateur {

	public Etudiant(String numEtudiant, String mdp, String email, String nom, String prenom) {
        super(numEtudiant, mdp, nom, prenom, email);
	}
	
	public Etudiant(String numEtudiant, String mdp) {
        super(numEtudiant, mdp);
	}
	
	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

}
