package com.reservationmachines.model;

public class Etudiant extends Utilisateur {
    public Etudiant() {
        super();
    }

    public Etudiant(String identifiant, String mdp) {
        super(identifiant, mdp);
    }

    public Etudiant(String identifiant, String mdp, String nom, String prenom) {
        super(identifiant, mdp, nom, prenom);
    }
}
