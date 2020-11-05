package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.EtatSalle;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.ResponsableTP;
import com.reservationmachines.model.Salle;


public class AdminControler extends Controler {
	
	public AdminControler(AbstractModel model) {
		super(model);
	}


	public boolean creerCompteEtudiant(
		String noEtudiant, String mdp, String email, String nom, String prenom) {
		Etudiant etudiant = new Etudiant(noEtudiant, mdp, email, nom, prenom);
		model.creerCompteEtudiant(etudiant);
		return false;
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
	public boolean misAjourInBD(String identi,String nom,String prenom ,String email, String rePwd){
		return false;
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
		model.ajoutSalle(nomS);
	}
	
	public String[][] getSalle() {
		return model.getSalles();
	}
	
	public void supprimerSalle(String nomS) {
		model.supprimerSalle(nomS) ;
	}

	public String getMotDePasse() {
		return model.getAdmin(id).getMdp();
	}
	
	public String[][] getMachine(String nomS) {
		return model.getMachines(nomS);
	}
	
	public Object[][]  getCompteE(){
		Object[][] t=null;
		return t;
	}


	public String[][] getReclamation() {
		return model.getReclamations(model.getAdmin(id).getIdentifiant());
	}


	public void traiterReclamation(String description) {
		model.traiterReclamation(description);
		
	}


	/*public String[] getListeNomSalle() {
		return model.getListeNomSalle();
	}*/


}