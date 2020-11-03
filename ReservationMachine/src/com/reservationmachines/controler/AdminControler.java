package com.reservationmachines.controler;


import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Admin;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.Model;


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

	public static boolean checkPasswordA(Admin admin, String strPwd) {
		boolean same = false;
		/*if (e.getMotdepasseC() == mdp) {
			same = true;
		}*/  // la methode pour verifier le mdp
		return same;
	}


	public void creerCompteResponsableTP(String text, String text2, String text3, String text4, String text5) {
		// TODO Auto-generated method stub
		
	}

}