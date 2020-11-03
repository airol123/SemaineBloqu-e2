package com.reservationmachines.view.main;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.controler.ResponsableTPControler;

public class SeConnecterView {

	private EtudiantControler c1;
	private ResponsableTPControler c2;
	private AdminControler c3;
	
	public SeConnecterView(EtudiantControler c1, ResponsableTPControler c2,
			AdminControler c3) {
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;		
	}
}
