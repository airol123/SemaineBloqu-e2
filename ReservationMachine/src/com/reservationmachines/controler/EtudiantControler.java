package com.reservationmachines.controler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.reservationmachines.model.*;

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
    	String id = trouverEtudiantId();
		return model.misAjourInBD(stremail, strRePwd,id);
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

	public String trouverEtudiantId() {
		String etudiantId =null;
		etudiantId = model.getEtudiant(id).getIdentifiant();
		return etudiantId;
	}

    public ReservationMachine[] trouverToutesLesReservation(String etudiant) {      
        ArrayList<ReservationMachine> reservations = model.getReservationMachineE(etudiant);
        int nbreservation=reservations.size();
        ReservationMachine[] rm = new ReservationMachine[nbreservation];
        for(int i = 0 ; i < nbreservation ; i++) {
        	rm[i]=reservations.get(i);
		}        
        return rm;
    }
    
	public ArrayList<Salle> trouverToutesLesSalles(){
		ArrayList<Salle> salles=model.getToutesLesSalles();	
		System.out.println(salles.size());
		return salles;
	}

	public boolean enregistrerReservation(String salle,String dateD,String dateF){
    	//get arraylist de Machine disponible
		ArrayList<Machine> machines = model.trouverMDisponible(salle,dateD,dateF);
		//System.out.println(machines.size()+"---*1*--");
		//System.out.println(machines.get(0).getNomMachine()+"---*2*--");
		//System.out.println(machines.get(1).getNomMachine()+"---*3*--");
		int n=machines.size();
		//Si il y une ou des machines
		if(n!=0){
		//Affecter une machine disponible aleatoirement a cet etudiant
			Etudiant etudiant=model.getEtudiant(this.trouverEtudiantId());
			Random rand = new Random();			
	    	int numI = rand.nextInt(n);
	        //System.out.println(numI);
	        Boolean enrM =model.affecterReservationM(machines.get(numI),etudiant,dateD,dateF);			
			return true;
		}
		//Sinon
		else{ 
			return false;	
		}

	}

	public boolean supprimerReservation(ReservationMachine reservationMachine) {
		boolean sup= model.supprimerRservation(reservationMachine);
		if(sup) {
    		return true;
    	}
    	else {
    		 return false;
    	} 
    }

    public boolean stockerReclamation(Reclamation re) {
    	boolean sto= model.stockerReclamation(re);
    	if(sto) {
    		return true;
    	}
    	else {
    		 return false;
    	}      
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