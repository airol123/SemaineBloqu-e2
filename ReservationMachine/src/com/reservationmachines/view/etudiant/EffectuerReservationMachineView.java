package com.reservationmachines.view.etudiant;

import javax.swing.*;

import com.reservationmachines.controler.EtudiantControler;

import java.awt.*;

public class EffectuerReservationMachineView {
    private JFrame jFrame=new JFrame("Reserver la machine");
    private EtudiantControler ec;
    private Container c = jFrame.getContentPane();
    //composition
    private JLabel titre = new JLabel("Reserver la machine");
    private JLabel lbIMsgC = new JLabel();




    
    private EtudiantControler controler;
    
    public EffectuerReservationMachineView(EtudiantControler controler) {

        this.controler = controler;
    }




    public JFrame getjFrame() {
        return jFrame;
    }
}
