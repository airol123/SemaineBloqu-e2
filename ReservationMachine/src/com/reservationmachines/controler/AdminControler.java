package com.reservationmachines.controler;


import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Etudiant;

public class AdminControler extends Controler {

	private AbstractModel model;
	
	public AdminControler(AbstractModel model) {
		super(model);
	}

	public void creerCompteEtudiant(
		String noEtudiant, String mdp, String email, String nom, String prenom) {
		Etudiant etudiant = new Etudiant(noEtudiant, mdp, email, nom, prenom);
		model.creerCompteEtudiant(etudiant);
	}

}