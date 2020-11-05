package com.reservationmachines.controler;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.GroupeTP;
import com.reservationmachines.model.ReservationMachine;
import com.reservationmachines.model.ReservationSalle;
import com.reservationmachines.model.ResponsableTP;
import com.reservationmachines.model.Salle;

public class ResponsableTPControler extends Controler {

	public ResponsableTPControler(AbstractModel model) {
		super(model);
	}

    public static ResponsableTP trouverResponsableTP(ResponsableTP responsableTP) {
		ResponsableTP responsableTP1=new ResponsableTP();
		return responsableTP1;
    }

    // Renvoie l'entï¿½te correspondante aux rï¿½servation des machines
	public String[] getEnteteReservationMachine() {
		return model.getEnteteReservationMachine();
	}

	// Convertit les valeurs des rï¿½servations en donnï¿½es pour le JTable
	public Object[][] getValeursReservationMachine(String idSalle) {
		ArrayList<ReservationMachine> reservations = model.getValeursReservationMachine(idSalle);
		int nbLignes = reservations.size();
		int nbColonnes = model.getEnteteReservationMachine().length;
		Object[][] objects = new Object[nbLignes][nbColonnes];
		
		for(int i = 0 ; i < nbLignes ; i++) {
			objects[i][0] = reservations.get(i).getNomMachine();
			objects[i][1] = reservations.get(i).getEtatMachine();
			objects[i][2] = reservations.get(i).getNomEtudiant();
			objects[i][3] = reservations.get(i).getPrenomEtudiant();
		}
		
		return objects;
	}

	public boolean verifierMotDePasseResponsableTP(String idResponsableTP, String mdp) {
    	if(model.verifierMotDePasseResponsableTP(idResponsableTP, mdp)) {
    		this.connexion(idResponsableTP);
    		return true;
    	}
    	return false;
	}

	public String[] recupererFormations() {
		ArrayList<String> formations = model.recupererNomsFormations();
		String[] result = new String[formations.size()];
		
		for(int i = 0 ; i < formations.size() ; i++)
			result[i] = formations.get(i);
		
		return result;
	}

	public String[] recupererGroupeTP(String idFormation) {
		ArrayList<GroupeTP> groupes = model.recupererNomsGroupesTP(idFormation);
		String[] result = new String[groupes.size()];
		
		for(int i = 0 ; i < groupes.size() ; i++)
			result[i] = groupes.get(i).getNomGroupe();
		
		return result;
	}

	public String[] getReservationsSallesDates() {
		return model.getReservationsSallesDates();
	}

	public Object[][] getValeursSallesDisponibles(String date, String heureDebut, String heureFin) {
		ArrayList<Salle> salles = model.getValeursSallesDisponibles(date, heureDebut, heureFin);
		int nbLignes = salles.size();
		int nbColonnes = model.getEnteteReservationMachine().length;
		Object[][] objects = new Object[nbLignes][nbColonnes];
		
		for(int i = 0 ; i < nbLignes ; i++) {
			objects[i][0] = salles.get(i).getNomSalle();
			objects[i][1] = salles.get(i).getCapacite();
			
			JButton myButton = new JButton("Sélectionner");
			objects[i][2] = myButton;
		}
		
		return objects;
	}

	public void reserverSalle(String nomSalle, String nomGroupe, String formation, String dateArg, String heureDebutArg, String heureFinArg, String nomCours) {
		ResponsableTP responsableTP = new ResponsableTP(this.id);
		Salle salle = new Salle(nomSalle);
		GroupeTP groupeTP = new GroupeTP(nomGroupe);
		Date date = Date.valueOf(dateArg);
		Timestamp heureDebut = Timestamp.valueOf(heureDebutArg);
		Timestamp heureFin = Timestamp.valueOf(heureFinArg);
		
		model.reserverSalle(new ReservationSalle(nomCours, responsableTP, salle, groupeTP, formation, date, heureDebut, heureFin));
	}

	public String[] getEnteteSallesDisponibles() {
		return model.getEnteteSallesDisponibles();
	}

	public String[] getReservationsSallesHeuresDebuts() {
		return model.getReservationsSallesHeuresDebuts();
	}
	
	public String[] getReservationsSallesHeuresDebuts(String heureFin) {
		return model.getReservationsSallesHeuresDebuts(heureFin);
	}

	public String[] getReservationsSallesHeuresFins() {
		return model.getReservationsSallesHeuresFins();
	}

	public String[] getReservationsSallesHeuresFins(String heureDebut) {
		return model.getReservationsSallesHeuresFins(heureDebut);
	}

	public String[] recupererNomTP() {
		return model.recupererNomTP(this.id);
	}

	public Object[][] getValeursSallesReservees() {
		ArrayList<ReservationSalle> reservations = model.getValeursReservees(this.id);
		int nbLignes = reservations.size();
		int nbColonnes = model.getEnteteSallesReservees().length;
		Object[][] objects = new Object[nbLignes][nbColonnes];
		
		for(int i = 0 ; i < nbLignes ; i++) {
			objects[i][0] = reservations.get(i).getNomCours();
			objects[i][1] = reservations.get(i).getNomFormation();
			objects[i][2] = reservations.get(i).getNomGroupeTP();
			objects[i][3] = reservations.get(i).getDate();
			objects[i][4] = reservations.get(i).getHeureDebut();
			objects[i][5] = reservations.get(i).getHeureFin();
			objects[i][6] = reservations.get(i).getNomSalle();
			objects[i][7] = reservations.get(i).getCapacite();
			objects[i][8] = "Voir l'état des machines";
			objects[i][9] = "Annuler";
		}
		
		return objects;
	}

	public String[] getEnteteSallesReservees() {
		return model.getEnteteSallesReservees();
	}
	
	public String getPrenom() {
		return model.getPrenomResponsableTP(this.id);
	}

	public void annulerReservationSalle(String idSalle) {
		model.annulerReservationSalle(idSalle);
	}
	
	public void annulerToutesReservationsMachinesSalle(String idSalle) {
		model.annulerToutesReservationsMachinesSalle(idSalle);
	}
}