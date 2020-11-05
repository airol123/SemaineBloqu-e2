package com.reservationmachines.model;

import java.util.ArrayList;

public class GroupeTP {
	private String nomGroupe;
	private String nomFormation;
	private ArrayList<Etudiant> etudiants;
	
	public GroupeTP(String nomGroupe) {
		this.nomGroupe = nomGroupe;
		this.nomFormation = null;
		this.etudiants = null;
	}
	
	public String getNomGroupe() {
		return this.nomGroupe;
	}
}