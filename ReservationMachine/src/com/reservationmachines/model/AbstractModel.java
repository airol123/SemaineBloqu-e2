package com.reservationmachines.model;

import java.util.ArrayList;

public abstract class AbstractModel {

	public abstract String[] getEnteteReservationMachine();
	public abstract ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle);
	public abstract void creerCompteEtudiant(Etudiant etudiant);


}
