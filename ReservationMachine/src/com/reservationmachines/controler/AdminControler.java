package com.reservationmachines.controler;

import java.util.ArrayList;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.EtatMachine;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.Machine;
import com.reservationmachines.model.ReservationMachine;
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
		Salle salle = new Salle(nomSalle);
		Machine machine = new Machine(nomMachine, EtatMachine.DISPONIBLE, salle);
		model.setMachineSalle(machine);
	}
	public boolean misAjourInBD(String identifiant,String nom,String prenom ,String email, String rePwd){
		//Ajouter panduan-type est etudiant ou resp
		boolean mis=false;
		if(this.getTypeModifierCurrent().equals("Etudaint")) {
			mis=model.miseAJourcompteE(identifiant,nom,prenom,email,rePwd);
			System.out.println("etu"+mis);
		}else if(this.getTypeModifierCurrent().equals("Responsable TP")) {
			mis=model.miseAJourcompteR(identifiant,nom,prenom,email,rePwd);
			System.out.println("eres"+mis);
		}
		if(mis) {
			return true;
		}else {
			return false;
		}
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

	public void supprimerMachine(String nomM) {
		model.supprimerMachine(nomM) ;
	}

	public Object[][]  getCompteE(){
		ArrayList<Etudiant> etudiants = model.getTousLesEtudiant();
		ArrayList<ResponsableTP> respTPs = model.getTousLesRespTP();

		int nbLignesResp=respTPs.size();
		int nbLignesEtu = etudiants.size();
		int nbLignesTotal=nbLignesResp+nbLignesEtu;

		int nbColonnes = model.getEnteteReservationMachine().length;
		Object[][] objects = new Object[nbLignesTotal][nbColonnes];

		for(int i = 0 ; i < nbLignesResp ; i++) {
			objects[i][0] = "Responsable TP";
			objects[i][1] = respTPs.get(i).getIdentifiant();
			objects[i][2] =	respTPs.get(i).getNom();
			objects[i][3] = respTPs.get(i).getPrenom();
		}
		for(int x = nbLignesResp ; x < nbLignesTotal ; x++) {
			int y=x-nbLignesResp;
			objects[x][0] = "Etudaint";
			objects[x][1] = etudiants.get(y).getIdentifiant();
			objects[x][2] =	etudiants.get(y).getNom();
			objects[x][3] = etudiants.get(y).getPrenom();
		}
		return objects;
	}

	public String idModifierCurrent;
	public void id(String id) {
		this.idModifierCurrent=id;
		System.out.println("contole:"+idModifierCurrent);
	}
	public String getIdModifierCurrent() {
		return idModifierCurrent;
	}

	private String typeModifierCurrent;
	public void type(String type) {
		this.typeModifierCurrent=type;
	}
	public String getTypeModifierCurrent() {
		return typeModifierCurrent;
	}


	public String[][] getReclamation() {
		return model.getReclamations(model.getAdmin(id).getIdentifiant());
	}


	public void traiterReclamation(String description) {
		model.traiterReclamation(description);

	}


	public String[] getListeNomSalle() {
		return model.getListeNomSalle();
	}


}