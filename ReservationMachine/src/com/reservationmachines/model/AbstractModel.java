package com.reservationmachines.model;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractModel {


	public abstract String[] getEnteteReservationMachine();
	public abstract ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle);
	public abstract void creerCompteEtudiant(Etudiant etudiant);
	public abstract void creerCompteResponsableTP(ResponsableTP responsableTP) ;
	public abstract void setMachineSalle(String nomMachine, String nomSalle);
	public abstract String[] getListeNomSalle() throws SQLException;

}
