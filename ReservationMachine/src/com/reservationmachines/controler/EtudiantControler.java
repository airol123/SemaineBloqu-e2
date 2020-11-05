package com.reservationmachines.controler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

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
    	//1.get arraylist de Machine disponible
		//2. if(arraylist.size!=null){
		//  affecter une machine
		//  return true
		//}
		//3.else{ return false;}


		dateD = dateD + ":00";
		DateTimeFormatter fommatter1 =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime1  = LocalDateTime.parse(dateD, fommatter1);//datetime: 2020-11-05T08:06
		//System.out.println("datetime: "+dateTime1);
		Timestamp timestamp = Timestamp.valueOf(dateTime1);//timestamp: 2020-11-05 08:06:00.0
		//System.out.println("timestamp: "+timestamp);



		/*DateTime time = new DateTime(new Date());
		Date date = time.toDate();
		DateTime time2 = new DateTime(System.currentTimeMillis());
		time2.getMillis();*/
		return false;
	}




	public static void supprimerReservation(ReservationMachine reservationMachine) {
        //supprimer cette reservation dans BD
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