package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;

public abstract class Controler {
	
	@SuppressWarnings("unused")
	protected AbstractModel model;
	@SuppressWarnings("unused")
	private String id;
	
	public Controler(AbstractModel model) {
		this.model = model;
		// Aucun utilisateur connecté pour le moment
		this.id = null;
	}
	
	// On conserve l'identifiant de l'utilisateur qui s'est connecté
	public void connexion(String id) {
		this.id = id;
	}

	// On supprimer l'identifiant de l'utilisateur qui s'est connecté
	public void deconnexion() {
		this.id = null;
	}
}
