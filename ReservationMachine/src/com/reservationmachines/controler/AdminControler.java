package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Etudiant;
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

	public boolean verifierMotDePasseAdmin(String idAdmin, String mdp) {
    	if(model.verifierMotDePasseAdmin(idAdmin, mdp)) {
    		this.connexion(idAdmin);
    		return true;
    	}
    	return false;
	}

	public void creerCompteResponsableTP(
			String id, String mdp, String email, String nom, String prenom) {
			ResponsableTP responsableTP = new ResponsableTP(id, mdp, email, nom, prenom);
			model.creerCompteResponsableTP(responsableTP);
	}

	public void ajouterMachineSalle(String nomMachine, String nomSalle) {
		//Machine machine = new Machine(nomMachine, EtatMachine.DISPONIBLE);
		model.setMachineSalle(nomMachine, nomSalle);
	}

	public String[] getListeNomSalle(){
		String[] s=null;
		return s;

	}
}