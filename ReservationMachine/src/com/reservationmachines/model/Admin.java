package com.reservationmachines.model;

public class Admin extends Utilisateur {
	public Admin() {
		super();
	}

	public Admin(String identifiant, String mdp) {
		super(identifiant, mdp);
	}

	public Admin(String identifiant, String mdp, String email, String nom, String prenom) {
		super(identifiant, mdp, email, nom, prenom);
	}
}