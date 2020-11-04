package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;

public abstract class Controler {
	
	protected AbstractModel model;
	@SuppressWarnings("unused")
	private String id;
	
	public Controler(AbstractModel model) {
		this.model = model;
		// Aucun utilisateur connect� pour le moment
		this.id = null;
	}
	
	// On conserve l'identifiant de l'utilisateur qui s'est connect�
	public void connexion(String id) {
		this.id = id;
	}

	// On supprimer l'identifiant de l'utilisateur qui s'est connect�
	public void deconnexion() {
		this.id = null;
	}
}
