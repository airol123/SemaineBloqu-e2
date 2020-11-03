package com.reservationmachines.model;

public class Etudiant extends Utilisateur {
    private String email;
    public Etudiant() {
        super();
    }

    public Etudiant(String identifiant, String mdp) {
        super(identifiant, mdp);
    }

    public Etudiant(String identifiant, String mdp, String nom, String prenom, String email) {
        super(identifiant, mdp, nom, prenom);
        this.email = email;
    }
}
