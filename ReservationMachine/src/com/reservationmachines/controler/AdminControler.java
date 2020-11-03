package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.model.Model;


public class AdminControler extends Controler {

	private AbstractModel model;
	
	public AdminControler(Model model) {
		super(model);
	}


	public static boolean checkPasswordA(Admin admin, String strPwd) {
		boolean same = false;
		/*if (e.getMotdepasseC() == mdp) {
			same = true;
		}*/  // la methode pour verifier le mdp
		return same;
	}

}