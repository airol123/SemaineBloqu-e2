package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Admin;

public class AdminControler extends Controler {

	public AdminControler(AbstractModel model) {
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