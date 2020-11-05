package com.reservationmachines.view.responsabletp;

import javax.swing.JOptionPane;

import com.reservationmachines.controler.ResponsableTPControler;

public class AnnulerReservationSalleView {

	public AnnulerReservationSalleView(String idSalle, ResponsableTPControler controler) {
		// Si le responsable TP a confirm� l'annulation,
		if(JOptionPane.showConfirmDialog(
				null,
				"Vous �tes sur le point d'annuler votre r�servation !\n" +
				"Souhaitez-vous confirmer ?", 
				"Annulation de la r�servation de la salle " + idSalle,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			// alors on annule la r�servation de la salle
			controler.annulerReservationSalle(idSalle);

			// et on lui demande s'il souhaite �galement annuler 
			// les r�servations machines des �tudiants de son TP pour la m�me salle
			if(JOptionPane.showConfirmDialog(
				null,
				"Souhaitez-vous �galement annuler les r�servations des �tudiants " +
				"de votre TP ?", 
				"Annulation des r�servations des machines de la salle " + idSalle,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				
				// S'il confirme, alors on annule toutes les r�servations machines
				controler.annulerToutesReservationsMachinesSalle(idSalle);
			}
		}
	}

}
