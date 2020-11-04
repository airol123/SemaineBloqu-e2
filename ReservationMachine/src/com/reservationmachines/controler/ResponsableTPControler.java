package com.reservationmachines.controler;

import java.util.ArrayList;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.GroupeTP;
import com.reservationmachines.model.ReservationMachine;
import com.reservationmachines.model.ResponsableTP;

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
}