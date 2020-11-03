package com.reservationmachines.view.etudiant;

import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.view.main.SeConnecterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PageEtudiant {
    private JFrame jFrame = new JFrame("Page Personnelle");
    private Container c = jFrame.getContentPane();

    private JLabel titre = new JLabel("Page Personnelle");
    private JLabel lbBon = new JLabel("Bonjour, ");
    private JLabel lbNom=new JLabel() ;

    private JButton btnreserv = new JButton("Réserver la machine");
    private JButton btnconsPro = new JButton("Mon profil");
    private JButton btnconsReserv = new JButton("Mes réservations");
    private JButton btndeconnec = new JButton("Se déconnecter");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);
    private Etudiant etudiant=new Etudiant();

    public PageEtudiant(Etudiant etu ) { //
         this.etudiant=etu;

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

        btnconsPro.setBounds(410,150,250,50);
        btnconsReserv.setBounds(410,220,250,50);
        btnreserv.setBounds(410,290,250,50);
        btndeconnec.setBounds(740,440,200,30);
        btndeconnec.setBackground(Color.LIGHT_GRAY);
        lbBon.setBounds(700,80,50,20);
        lbNom.setBounds(750,80,100,20);
        fieldPanel.add(titre);
        fieldPanel.add(lbBon);
        fieldPanel.add(lbNom);
        fieldPanel.add(btnconsPro);
        fieldPanel.add(btnconsReserv);
        fieldPanel.add(btndeconnec);
        fieldPanel.add(btnreserv);
        fieldPanel.add(lblBackground);

        lbNom.setText(etudiant.getPrenom());

        c.add(fieldPanel, "Center");



        //----------------------------listener--------------------------------
        btndeconnec.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                SeConnecterView sc = new SeConnecterView();
                sc.getjFrame().setVisible(true);

            }
        });

        btnconsPro.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            jFrame.setVisible(false);
            ConsulterMonProfil cp = new ConsulterMonProfil();//Etudiant etudiant
            cp.getjFrame().setVisible(true);

        }
        });

        btnconsReserv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                ConsulterReservationView cr = new ConsulterReservationView(); //Etudiant etudiant
                cr.getjFrame().setVisible(true);
            }
        });

        btnreserv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                EffectuerReservationMachineView er = new EffectuerReservationMachineView(); //Etudiant etudiant
                er.getjFrame().setVisible(true);
            }
        });



    }
    public JFrame getjFrame() {
        return jFrame;
    }
}
