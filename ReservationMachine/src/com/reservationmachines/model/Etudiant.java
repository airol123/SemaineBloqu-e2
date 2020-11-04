package com.reservationmachines.model;

public class Etudiant extends Utilisateur {
	public Etudiant() {
		super();
	}

	public Etudiant(String numEtudiant, String mdp, String nom, String prenom, String email) {
        super(numEtudiant, mdp, nom, prenom, email);
	}
	
	public Etudiant(String numEtudiant, String mdp) {
        super(numEtudiant, mdp);
	}
}
