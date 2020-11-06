package com.reservationmachines.view.responsabletp;

import java.util.HashMap;

import javax.swing.JOptionPane;

import com.reservationmachines.controler.ResponsableTPControler;

public class AnnulerReservationSalleView {

	private ConsulterReservationSalleView view;

	public AnnulerReservationSalleView(HashMap<String, String> values, ConsulterReservationSalleView view, String idSalle, ResponsableTPControler controler) {
		this.view = view;
		boolean annulation1 = false;

		// Si le responsable TP a confirm� l'annulation,
		if(JOptionPane.showConfirmDialog(
				view,
				"Vous �tes sur le point d'annuler votre r�servation !\n" +
						"Souhaitez-vous confirmer ?", 
						"Annulation de la r�servation de la salle " + idSalle,
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			// alors on annule la r�servation de la salle
			annulation1 = controler.annulerReservationSalle(values);

			// et on lui demande s'il souhaite �galement annuler 
			// les r�servations machines des �tudiants de son TP pour la m�me salle
			if(JOptionPane.showConfirmDialog(
					view,
					"Souhaitez-vous �galement annuler les r�servations des �tudiants " +
							"de votre TP ?", 
							"Annulation des r�servations des machines de la salle " + idSalle,
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				// S'il confirme, alors on annule toutes les r�servations machines
				int i = controler.annulerToutesReservationsMachinesSalle(values);

				String message = (annulation1) ? "L'annulation de votre réservation a bien été effectuée !" : "Une erreur s'est produite lors de la tentative d'annulation !";
				message += "\r\n";
				message += (i > 0) ? "Il y a eu " + i + " annulation(s) de réservation machine !" : "Pas d'annulation de réservation machine !";
				JOptionPane.showMessageDialog(view, message);
			} else if(annulation1) {
				JOptionPane.showMessageDialog(view, "L'annulation de votre réservation a bien été effectuée !", "Confirmation d'annulation", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(view, "Une erreur s'est produite lors de la tentative d'annulation !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}

			this.view.updateTable();
		}
	}

}
