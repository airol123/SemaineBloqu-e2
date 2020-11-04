package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.Reclamation;
import com.reservationmachines.model.ReservationMachine;

public class EtudiantControler extends Controler {

    public EtudiantControler(AbstractModel model) {
        super(model);
    }

    public boolean verifierMotDePasseEtudiant(String numEtudiant, String mdp) {
    	if(model.verifierMotDePasseEtudiant(numEtudiant, mdp)) {
    		this.connexion(numEtudiant);
    		return true;
    	}
    	return false;
    }

    public void misAjourInBD(Etudiant etudiant) {

    }


	public boolean inscrireEtudiant(String strident, String strPwd, String strNom, String strPrenom, String strEmail) {
		return model.inscrireEtudiant(new Etudiant(strident, strPwd, strNom, strPrenom, strEmail));
	}

    public Etudiant trouverEtudiant(Etudiant etu ) {
        Etudiant etudiant = new Etudiant();

        return etudiant;
    }

    public ReservationMachine[] trouverToutesLesReservation(Etudiant etudiant) {
        ReservationMachine[] rm = null;
        return rm;
    }

    public static void supprimerReservation(ReservationMachine reservationMachine) {
        //supprimer cette reservation dans BD
    }

    public static void stockerReclamation(Reclamation re) {
        //stocker la reclamation dans BD
    }

	public String getPrenom() {
		return model.getPrenomEtudiant(id);
	}

	public void methode(String strident) {
		
	}
}