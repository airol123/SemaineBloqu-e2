package com.reservationmachines.view.etudiant;

import javax.swing.*;

import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.view.main.EtudiantMainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EffectuerReservationMachineView {
    private JFrame jFrame=new JFrame("Reserver la machine");
    private Container c = jFrame.getContentPane();
    //composition
    private JLabel titre = new JLabel("Reserver la machine");
    private JLabel lbIMsgC = new JLabel();
    private JLabel lbBon = new JLabel("Bonjour, ");
    private JLabel lbNom = new JLabel();
    private JLabel lbSal = new JLabel("Salle");
    private JLabel lbSalle = new JLabel();
    private JLabel lbDeb = new JLabel("Date Debut");
    private JLabel lbDebur = new JLabel();
    private JLabel lbF = new JLabel("Date Fin");
    private JLabel lbFin = new JLabel();
    private JButton btnRetour = new JButton("Retourner");
    private JButton btnValider = new JButton("Valider");
    private DateChooserJButton btnDateD = new DateChooserJButton();
    private DateChooserJButton btnDateF = new DateChooserJButton();


    // background && font
    private JLabel lblBackground = new JLabel();
    private ImageIcon icon = new ImageIcon("ReservationMachine/images/background2.jpg");
    private Font font = new Font("Arial", Font.BOLD, 36);

    String[] listData;//= new String[]{"ME403","ME405",  "ME407", "ME410"};


    private EtudiantControler controler;

    public EffectuerReservationMachineView(EtudiantControler controler) {

        this.controler = controler;

        titre.setFont(font);
        titre.setBounds(390, 20, 500, 40);
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

        listData = new String[controler.trouverToutesLesSalles().size()];
        for (int i = 0; i < controler.trouverToutesLesSalles().size(); i++) {
            listData[i] = controler.trouverToutesLesSalles().get(i).getNomSalle();
        }
        final JComboBox<String> comboBox = new JComboBox<String>(listData);

        lblBackground.setIcon(icon); // Définir l'icône à afficher par le composant d'étiquette
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbNom.setText(controler.getPrenom());
        lbIMsgC.setForeground(Color.RED);
        lbIMsgC.setBounds(450, 300, 300, 25);
        lbSal.setBounds(360, 150, 100, 30);
        comboBox.setBounds(500, 150, 220, 30);
        lbDeb.setBounds(360, 190, 100, 30);

        lbF.setBounds(360, 230, 100, 30);

        lbBon.setBounds(700, 80, 50, 20);
        lbNom.setBounds(750, 80, 100, 20);

        btnValider.setBounds(360, 400, 180, 30);
        btnRetour.setBounds(540, 400, 180, 30);
        btnDateD.setBounds(500, 190, 220, 30);
        btnDateD.setBackground(new java.awt.Color(176, 196, 222));
        btnDateF.setBackground(new java.awt.Color(176, 196, 222));
        btnDateF.setBounds(500, 230, 220, 30);

        // Définit l'élément sélectionné par défaut
        comboBox.setSelectedIndex(2);

        fieldPanel.add(lbBon);
        fieldPanel.add(titre);
        fieldPanel.add(lbIMsgC);
        fieldPanel.add(lbNom);
        fieldPanel.add(lbDeb);
        fieldPanel.add(lbDebur);
        fieldPanel.add(lbSal);
        fieldPanel.add(lbSalle);
        fieldPanel.add(lbF);
        fieldPanel.add(lbFin);
        fieldPanel.add(btnRetour);
        fieldPanel.add(btnValider);
        fieldPanel.add(btnDateD);
        fieldPanel.add(btnDateF);
        fieldPanel.add(comboBox);

        fieldPanel.add(lblBackground);


        c.add(fieldPanel, "Center");
        //----------------------------listener--------------------------------


        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                new EtudiantMainView(controler);
            }
        });

        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnDateD.getDateActuelle();
                btnDateF.getDateActuelle();
              /*  int choix = controler.enregistrerReservation(comboBox.getSelectedItem().toString(), btnDateD.getDateActuelle(), btnDateF.getDateActuelle())
                switch (choix) {
                    case 1:
                        lbIMsgC.setText("La salle a été réservée");
                        break;
                    case 2:
                        lbIMsgC.setText("Opération réussie!");
                        break;
                    case 3:
                        lbIMsgC.setText("Raison inconnue, l'opération a échoué");
                        break;
                    case 4:
                        lbIMsgC.setText("Non machine disponible dans cette salle");
                        break;
                }*/


               /* if (controler.enregistrerReservation(comboBox.getSelectedItem().toString(), btnDateD.getDateActuelle(), btnDateF.getDateActuelle())) {
                    lbIMsgC.setText("Opération réussie!");
                } else {
                    lbIMsgC.setText("Non machine disponible");
                }*/
                int choix = controler.enregistrerReservation(comboBox.getSelectedItem().toString(), btnDateD.getDateActuelle(), btnDateF.getDateActuelle());
                System.out.println(choix);
                switch (choix) {
                    case 1:
                        lbIMsgC.setText("La salle a été réservée");
                        break;
                    case 2:
                        lbIMsgC.setText("Opération réussie!");
                        break;
                    case 3:
                        lbIMsgC.setText("Raison inconnue, l'opération a échoué");
                        break;
                    case 4:
                        lbIMsgC.setText("Non machine disponible dans cette salle");
                        break;
                }

            }
        });

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Traiter uniquement l'état sélectionné
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("select: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());

                }
            }
        });
    }




    public JFrame getjFrame() {
        return jFrame;
    }
}
