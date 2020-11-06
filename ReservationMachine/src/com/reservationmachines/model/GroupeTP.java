package com.reservationmachines.model;

public class GroupeTP {
	private String nomGroupe;
	private String nomFormation;
	public GroupeTP(String nomGroupe) {
		this.nomGroupe = nomGroupe;
		this.nomFormation = null;
	}

	public GroupeTP(String nomGroupeTP, String nomFormation) {
		this(nomGroupeTP);
		this.nomFormation = nomFormation;
	}

	public String getNomGroupe() {
		return this.nomGroupe;
	}

	public String getNomFormation() {
		return this.nomFormation;
	}
}