package com.reservationmachines.controler;

import com.reservationmachines.model.Model;
import com.reservationmachines.model.Machine;

public class AdminControler extends Controler {

	public AdminControler(Model model) {
		super(model);
	}

	public void ajouterMachineSalle(String nomMachine, String nomSalle) {
		Machine machine = new Machine(nomMachine);
		model.setMachineSalle(nomMachine, nomSalle);
		
	}

}