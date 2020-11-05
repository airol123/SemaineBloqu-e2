package com.reservationmachines.controler;

import java.util.HashMap;

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

    public boolean misAjourInBD(String stremail, String strRePwd) {
		return model.misAjourInBD(stremail, strRePwd);
    }


	public boolean inscrireEtudiant(String strident, String strPwd, String strNom, String strPrenom, String strEmail) {
		return model.inscrireEtudiant(new Etudiant(strident, strPwd, strNom, strPrenom, strEmail));
	}

    public HashMap<String, String> trouverEtudiant() {
    	HashMap<String, String> etudiant = new HashMap<String, String>();
    	Etudiant etudiantModel = model.getEtudiant(id);
    	
    	etudiant.put("ide", etudiantModel.getIdentifiant());
    	etudiant.put("mdpe", etudiantModel.getMdp());
    	etudiant.put("nome", etudiantModel.getNom());
    	etudiant.put("prenome", etudiantModel.getPrenom());
    	etudiant.put("emaile", etudiantModel.getEmail());
    	
        return etudiant;
    }

    public ReservationMachine[] trouverToutesLesReservation(Etudiant etudiant) {
        ReservationMachine[] rm = null;
        return rm;
    }

    public void supprimerReservation(ReservationMachine reservationMachine) {
        //supprimer cette reservation dans BD
    }

    public void stockerReclamation(Reclamation re) {
        //stocker la reclamation dans BD
    }

	public void methode(String strident) {
		
	}

	public String getPrenom() {
		return model.getEtudiant(id).getPrenom();
	}
	
	public String getEmail() {
		return model.getEtudiant(id).getEmail();
	}

	public String getIdentifiant() {
		return model.getEtudiant(id).getIdentifiant();
	}

	public String getNom() {
		return model.getEtudiant(id).getNom();
	}
	
	public String getMotDePasse() {
		return model.getEtudiant(id).getMdp();
	}
}