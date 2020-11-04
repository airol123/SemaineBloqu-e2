package com.reservationmachines.view.etudiant;

import javax.swing.*;

import com.reservationmachines.controler.EtudiantControler;

public class EffectuerReservationMachineView {
    private JFrame jFrame=new JFrame("Reserver la machine");
    
    private EtudiantControler controler;
    
    public EffectuerReservationMachineView(EtudiantControler controler) {
    	this.controler = controler;
    }
    
    public JFrame getjFrame() {
        return jFrame;
    }
}
