package com.reservationmachines.view.etudiant;

import javax.swing.*;

import com.reservationmachines.controler.EtudiantControler;

import java.awt.*;
import java.net.URL;

public class EffectuerReservationMachineView {
    private JFrame jFrame=new JFrame("Reserver la machine");
    private EtudiantControler ec;
    private Container c = jFrame.getContentPane();
    //composition
    private JLabel titre = new JLabel("Reserver la machine");
    private JLabel lbIMsgC = new JLabel();
    private JLabel lbBon = new JLabel("Bonjour, ");
    private JLabel lbNom = new JLabel();
    private JLabel lbSal = new JLabel("Salle");
    private JLabel lbSalle = new JLabel();
    private JLabel lbDeb = new JLabel("Debut");
    private JLabel lbDebur = new JLabel();
    private JLabel lbF = new JLabel("Fin");
    private JLabel lbFin = new JLabel();
    private JButton btnRetour = new JButton("Retourner");
    private JButton btnValider = new JButton("Valider");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font = new Font("Arial", Font.BOLD, 36);



    
    private EtudiantControler controler;
    
    public EffectuerReservationMachineView(EtudiantControler controler) {

        this.controler = controler;
    }




    public JFrame getjFrame() {
        return jFrame;
    }
}
