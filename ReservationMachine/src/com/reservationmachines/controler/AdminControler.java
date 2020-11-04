package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Admin;
import com.reservationmachines.model.EtatMachine;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.Machine;
import com.reservationmachines.model.ResponsableTP;


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


	public void creerCompteResponsableTP(
			String id, String mdp, String email, String nom, String prenom) {
			ResponsableTP responsableTP = new ResponsableTP(id, mdp, email, nom, prenom);
			model.creerCompteResponsableTP(responsableTP);
	}

	public void ajouterMachineSalle(String nomMachine, String nomSalle) {
		Machine machine = new Machine(nomMachine, EtatMachine.DISPONIBLE);
		model.setMachineSalle(nomMachine, nomSalle);

	}


	public String[] getListeNomSalle() {
		return model.getListeNomSalle();
	}
}