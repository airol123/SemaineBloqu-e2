package com.reservationmachines.view.admin;

import com.reservationmachines.controler.AdminControler;

import javax.swing.*;

public class ModifierCompteView {
    private AdminControler controler;
    private JFrame jFrame;
    public ModifierCompteView(AdminControler controler){
        this.controler=controler;
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
