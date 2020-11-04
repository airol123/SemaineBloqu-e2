package com.reservationmachines.view.admin;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.model.Admin;
import com.reservationmachines.view.main.SeConnecterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PageAdmin {
    private JFrame jFrame = new JFrame("Page Personnelle");
    private Container c = jFrame.getContentPane();

    private JLabel titre = new JLabel("Page Personnelle");
    private JLabel lbBon = new JLabel("Bonjour, ");
    private JLabel lbNom=new JLabel() ;

    private JButton btnCompte = new JButton("Gestion de compte");
    private JButton btnMachine = new JButton("Gestion de machine");
    private JButton btndeconnec = new JButton("Se déconnecter");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);
    private Admin admin;

    public PageAdmin(Admin admin) { //
        this.admin=admin;

        titre.setFont(font);
        titre.setBounds(390,20,300,40);
        jFrame.setBounds(600, 200, 1010, 550);
        //Mettre en place une couche de quelque chose d'équivalent à une nappe
        c.setLayout(new BorderLayout());//Gestionnaire de mise en page
        //Définir pour fermer après avoir appuyé sur le chiffre X dans le coin supérieur droit
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        //Initialisation-mettre d'autres contrôles dans le formulaire
        init();
        //Définir le formulaire pour qu'il soit visible
        jFrame.setVisible(true);
    }
    public void init() {
        lblBackground.setIcon(icon); // Définir l'icône à afficher par le composant d'étiquette
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        btnMachine.setBounds(410,147,250,50);
        btnCompte.setBounds(410,207,250,50);
        btndeconnec.setBounds(740,440,200,30);
        btndeconnec.setBackground(Color.LIGHT_GRAY);
        lbBon.setBounds(700,80,50,20);
        lbNom.setBounds(750,80,100,20);
        fieldPanel.add(titre);
        fieldPanel.add(lbBon);
        fieldPanel.add(lbNom);
        fieldPanel.add(btnMachine);
        fieldPanel.add(btndeconnec);
        fieldPanel.add(btnCompte);
        fieldPanel.add(lblBackground);

        lbNom.setText(admin.getPrenom());

        c.add(fieldPanel, "Center");
        
        JButton btnReclamation = new JButton("Gestion de réclamation");
        btnReclamation.setBounds(410, 267, 250, 50);
        fieldPanel.add(btnReclamation);



        //----------------------------listener--------------------------------
        btndeconnec.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                SeConnecterView sc = new SeConnecterView();
                sc.getjFrame().setVisible(true);

            }
        });

        btnMachine.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	// to-do
            }
        });

        btnCompte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // to-do
            }
        });



    }
    public JFrame getjFrame() {
        return jFrame;
    }
}
