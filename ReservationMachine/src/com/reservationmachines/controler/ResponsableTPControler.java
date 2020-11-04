package com.reservationmachines.controler;

import java.util.ArrayList;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.GroupeTP;
import com.reservationmachines.model.ReservationMachine;
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

    // Renvoie l'ent�te correspondante aux r�servation des machines
	public String[] getEnteteReservationMachine() {
		return model.getEnteteReservationMachine();
	}

	// Convertit les valeurs des r�servations en donn�es pour le JTable
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
		}
		
		return objects;
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
}