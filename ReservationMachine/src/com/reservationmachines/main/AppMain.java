package com.reservationmachines.main;

import com.reservationmachines.model.AbstractModel;
import com.reservationmachines.model.Model;
import com.reservationmachines.view.main.SeConnecterView;
import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.controler.ResponsableTPControler;
import com.reservationmachines.controler.AdminControler;

public class AppMain {

	public AppMain() {
		AbstractModel model = new Model();
		EtudiantControler c1 = new EtudiantControler(model);
		ResponsableTPControler c2 = new ResponsableTPControler(model);
		AdminControler c3 = new AdminControler(model);
		new SeConnecterView(c1, c2, c3);//
	}
	
	public static void main(String[] args) {
		new AppMain();
	}

}
