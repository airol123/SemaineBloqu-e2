package com.reservationmachines.view.etudiant;

import com.reservationmachines.model.Etudiant;
import com.reservationmachines.view.main.SeConnecterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ConsulterMonProfil {
    private JFrame jFrame = new JFrame("Mon Profil");
    private Container c = jFrame.getContentPane();
    private JLabel titre = new JLabel("Mon Profil");
    private JLabel lbBon = new JLabel("Bonjour, ");
    private JLabel lbNom=new JLabel() ;

    private JLabel lbemail=new JLabel("E-mail");
    private JLabel lbnumero=new JLabel("Numéro d'étudiant");
    private JLabel lbnom=new JLabel("Nom");
    private JLabel lbprenom=new JLabel("Prenom");
    private JLabel lbemailR=new JLabel("...");
    private JLabel lbnumeroR=new JLabel("...");
    private JLabel lbnomR=new JLabel("...");
    private JLabel lbprenomR=new JLabel("...");

    private JButton btnmodifier = new JButton("Modifier");
    private JButton btnreturn = new JButton("retourner");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);

    private Etudiant etudiant=new Etudiant();

    public ConsulterMonProfil( Etudiant etu) {
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

        lbBon.setBounds(700,80,50,20);
        lbNom.setBounds(750,80,100,20);
        lbnumero.setBounds(360,150,120,30);
        lbnom.setBounds(360,190,120,30);
        lbprenom.setBounds(360,220,120,30);
        lbemail.setBounds(360,250,120,30);
        lbnumeroR.setBounds(500,150,150,30);
        lbnomR.setBounds(500,190,150,30);
        lbprenomR.setBounds(500,220,150,30);
        lbemailR.setBounds(500,250,150,30);
        btnmodifier.setBounds(360,400,100,40);
        btnreturn.setBounds(550,400,100,40);

        fieldPanel.add(lbBon);
        fieldPanel.add(titre);
        fieldPanel.add(lbNom);
        fieldPanel.add(lbnumero);
        fieldPanel.add(lbnom);
        fieldPanel.add(lbprenom);
        fieldPanel.add(lbemail);
        fieldPanel.add(lbnumeroR);
        fieldPanel.add(lbnomR);
        fieldPanel.add(lbprenomR);
        fieldPanel.add(lbemailR);
        fieldPanel.add(btnmodifier);
        fieldPanel.add(btnreturn);
        fieldPanel.add(lblBackground);

        lbNom.setText(etudiant.getPrenom());

        c.add(fieldPanel, "Center");
        //----------------------------listener--------------------------------

        btnreturn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                PageEtudiant pe = new PageEtudiant(etudiant);
                pe.getjFrame().setVisible(true);

            }
        });

        btnmodifier.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                ModifierProfilView mo = new ModifierProfilView(etudiant);
                mo.getjFrame().setVisible(true);

            }
        });

    }


    public JFrame getjFrame() {
        return jFrame;
    }
}
