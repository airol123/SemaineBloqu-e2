package com.reservationmachines.model;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractModel {
	
	public abstract String[] getEnteteReservationMachine();
	public abstract ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle);
	public abstract void creerCompteEtudiant(Etudiant etudiant);
	public abstract void creerCompteResponsableTP(ResponsableTP responsableTP) ;
	public abstract void setMachineSalle(Machine machine);
	public abstract void ajoutSalle(String nomSalle);
	public abstract boolean verifierMotDePasseEtudiant(String numEtudiant, String mdp);
	public abstract boolean verifierMotDePasseResponsableTP(String idResponsableTP, String mdp);
	public abstract boolean verifierMotDePasseAdmin(String idAdmin, String mdp);
	public abstract Etudiant getEtudiant(String numEtudiant);
	public abstract String getPrenomResponsableTP(String idResponsableTP);
	//public abstract String getPrenomAdmin(String idAdmin);
	public abstract boolean inscrireEtudiant(Etudiant etudiant);
	public abstract ArrayList<String> recupererNomsFormations();
	public abstract ArrayList<GroupeTP> recupererNomsGroupesTP(String idFormation);
	public abstract boolean misAjourInBD(String stremail, String strRePwd, String id);
	public abstract String[] getReservationsSallesDates();
	public abstract ArrayList<Salle> getValeursSallesDisponibles(String date, String heureDebut, String heureFin);
	public abstract String[] getEnteteSallesDisponibles();
	public abstract String[] getReservationsSallesHeuresDebuts();
	public abstract String[] getReservationsSallesHeuresDebuts(String heureFin);
	public abstract String[] getReservationsSallesHeuresFins();
	public abstract String[] getReservationsSallesHeuresFins(String heureDebut);
	public abstract void reserverSalle(ReservationSalle reservationSalle);
	public abstract String[] recupererNomTP(String id);
	public abstract ArrayList<ReservationSalle> getValeursReservees(String id);
	public abstract String[] getEnteteSallesReservees();
	public abstract void annulerReservationSalle(String idSalle);
	public abstract void annulerToutesReservationsMachinesSalle(String idSalle);
	public abstract ArrayList<ReservationMachine> getReservationMachineE(String etudiant);
	public abstract ArrayList<Salle> getToutesLesSalles();
	public abstract Admin getAdmin(String numAdmin);
	public abstract String[][] getReclamations(String identifiant);
	public abstract void traiterReclamation(String description);
	public abstract boolean stockerReclamation(Reclamation re);
	public Etudiant seConnecter(String ide) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Admin seConnecterAdmin(String ida) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public ResponsableTP seConnecterResponsable(String idres) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public abstract String[] getListeNomSalle();
}
