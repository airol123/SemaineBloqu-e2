package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.Model;

public class AdminControler extends Controler {

	private AbstractModel model;
	
	public AdminControler(Model model) {
		super(model);
	}

	public void creerCompteResponsableTP(String id, String mdp, String email, String nom, String prenom) {
		ResponsableTP responsableTP = new ResponsableTP(id, mdp, email, nom, prenom);
		model.creerCompteResponsableTP(responsableTP);
		
	}

}