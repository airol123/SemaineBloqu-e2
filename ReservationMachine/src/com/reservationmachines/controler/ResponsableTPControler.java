package com.reservationmachines.controler;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.ResponsableTP;

public class ResponsableTPControler extends Controler {

	public ResponsableTPControler(AbstractModel model) {
		super(model);
	}

    public static boolean checkPasswordR(ResponsableTP responsableTP, String strPwd) {
		boolean same = false;
		/*if (e.getMotdepasseC() == mdp) {
			same = true;
		}*/  // la methode pour verifier le mdp
		return same;
    }
}