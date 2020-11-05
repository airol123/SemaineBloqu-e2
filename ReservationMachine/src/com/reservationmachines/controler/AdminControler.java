package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Admin;
import com.reservationmachines.model.EtatMachine;
import com.reservationmachines.model.EtatSalle;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.ResponsableTP;
import com.reservationmachines.model.Salle;


public class AdminControler extends Controler {
	
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
	
	public String getPrenom() {
		return model.getAdmin(id).getPrenom();
	}
	
	public String getEmail() {
		return model.getAdmin(id).getEmail();
	}

	public String getIdentifiant() {
		return model.getAdmin(id).getIdentifiant();
	}

	public String getNom() {
		return model.getAdmin(id).getNom();
	}
	
	public void ajouterSalle(String nomS) {
		Salle salle = new Salle(nomS, EtatSalle.DISPONIBLE);
		model.ajoutSalle(nomS);

	}

	public String getMotDePasse() {
		return model.getAdmin(id).getMdp();
	}

	public Object[][]  getCompteE(){
		Object[][] t=null;
		return t;
	}


	/*public String[] getListeNomSalle() {
		return model.getListeNomSalle();
	}*/


}