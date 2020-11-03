package com.reservationmachines.model;

public class ResponsableTP extends Utilisateur {
    public ResponsableTP(String identifiant, String mdp) {
        super(identifiant, mdp);
    }

    public ResponsableTP(String identifiant, String mdp, String nom, String prenom) {
        super(identifiant, mdp, nom, prenom);
    }
}
