package com.reservationmachines.model;

public class Admin extends Utilisateur {
    public Admin() {
    }

    public Admin(String identifiant, String mdp) {
        super(identifiant, mdp);
    }

    public Admin(String identifiant, String mdp, String nom, String prenom) {
        super(identifiant, mdp, nom, prenom);
    }
}