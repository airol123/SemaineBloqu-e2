package com.reservationmachines.view.admin;

import com.reservationmachines.controler.AdminControler;

import javax.swing.*;

public class ModifierCompteEtudiantView {
    private AdminControler controler;
    private JFrame jFrame;
    public ModifierCompteEtudiantView(AdminControler controler){
        this.controler=controler;
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
