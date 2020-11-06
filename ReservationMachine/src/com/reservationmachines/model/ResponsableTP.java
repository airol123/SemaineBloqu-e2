package com.reservationmachines.model;

public class ResponsableTP extends Utilisateur {
	public ResponsableTP() {
	}

	public ResponsableTP(String identifiant) {
		this.identifiant = identifiant;
	}

	public ResponsableTP(String identifiant, String mdp) {
		super(identifiant, mdp);
	}

	public ResponsableTP(String identifiant, String mdp, String nom, String prenom, String email) {
		super(identifiant, mdp, nom, prenom, email);
	}
}
