package com.reservationmachines.controler;


import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Admin;

public class AdminControler extends Controler {

	private Model model;
	
	public AdminControler(Model model) {
		super(model);
	}

	public void creerCompteEtudiant(
		String noEtudiant, String mdp, String email, String nom, String prenom) {
		Etudiant etudiant = new Etudiant(noEtudiant, mdp, email, nom, prenom);
		model.creerCompteEtudiant(etudiant);
	}

}