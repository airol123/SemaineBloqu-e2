package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.ReservationMachine;

public class EtudiantControler extends Controler {

    public EtudiantControler(AbstractModel model) {
        super(model);
    }

    public static boolean checkPasswordE(Etudiant e, String mdp) {
        boolean same = false;
		/*if (e.getMotdepasseC() == mdp) {
			same = true;
		}*/  // la methode pour verifier le mdp
        return same;
    }



    public static void misAjourInBD(Etudiant etudiant) {

    }

    public static void putEtudiantInBD(Etudiant etudiant) {
    }

    public static Etudiant trouverEtudiant(Etudiant etu ) {
        Etudiant etudiant = new Etudiant();

        return etudiant;
    }

    public static ReservationMachine[] trouverToutesLesReservation(Etudiant etudiant) {
        ReservationMachine[] rm = null;
        return rm;
    }

    public static void supprimerReservation(ReservationMachine reservationMachine) {
        //supprimer cette reservation dans BD
    }
}