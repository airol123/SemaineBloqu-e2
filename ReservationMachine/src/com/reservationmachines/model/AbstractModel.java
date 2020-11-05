package com.reservationmachines.model;

import java.util.ArrayList;

public abstract class AbstractModel {
	
	public abstract String[] getEnteteReservationMachine();
	public abstract ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle);
	public abstract void creerCompteEtudiant(Etudiant etudiant);
	public abstract void creerCompteResponsableTP(ResponsableTP responsableTP) ;
	public abstract void setMachineSalle(String nomMachine, String nomSalle);
	public abstract boolean verifierMotDePasseEtudiant(String numEtudiant, String mdp);
	public abstract boolean verifierMotDePasseResponsableTP(String idResponsableTP, String mdp);
	public abstract boolean verifierMotDePasseAdmin(String idAdmin, String mdp);
	public abstract Etudiant getEtudiant(String numEtudiant);
	//public abstract String getPrenomResponsableTP(String idResponsableTP);
	//public abstract String getPrenomAdmin(String idAdmin);
	public abstract boolean inscrireEtudiant(Etudiant etudiant);
	public abstract ArrayList<String> recupererNomsFormations();
	public abstract ArrayList<GroupeTP> recupererNomsGroupesTP(String idFormation);
	public abstract boolean misAjourInBD(String stremail, String strRePwd,String id);
	public abstract ArrayList<ReservationMachine> getReservationMachineE(String etudiant);
	public abstract ArrayList<Salle> getToutesLesSalles();
	public abstract boolean supprimerRservation(ReservationMachine reservationMachine);
	public abstract boolean stockerReclamation(Reclamation re);

}
