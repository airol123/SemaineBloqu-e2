package com.reservationmachines.view.responsabletp;

import javax.swing.JOptionPane;

import com.reservationmachines.controler.ResponsableTPControler;

public class AnnulerReservationSalleView {

	public AnnulerReservationSalleView(String idSalle, ResponsableTPControler controler) {
		// Si le responsable TP a confirmé l'annulation,
		if(JOptionPane.showConfirmDialog(
				null,
				"Vous êtes sur le point d'annuler votre réservation !\n" +
				"Souhaitez-vous confirmer ?", 
				"Annulation de la réservation de la salle " + idSalle,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			// alors on annule la réservation de la salle
			controler.annulerReservationSalle(idSalle);

			// et on lui demande s'il souhaite également annuler 
			// les réservations machines des étudiants de son TP pour la même salle
			if(JOptionPane.showConfirmDialog(
				null,
				"Souhaitez-vous également annuler les réservations des étudiants " +
				"de votre TP ?", 
				"Annulation des réservations des machines de la salle " + idSalle,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				
				// S'il confirme, alors on annule toutes les réservations machines
				controler.annulerToutesReservationsMachinesSalle(idSalle);
			}
		}
	}

}
