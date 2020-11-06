package com.reservationmachines.view.etudiant;

import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.model.*;
import com.reservationmachines.view.main.EtudiantMainView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ConsulterReservationView {
    private JFrame jFrame = new JFrame("Mes reservations");
    private Container c = jFrame.getContentPane();
    private JLabel titre = new JLabel("Mes reservations");
    private JLabel lbIMsgC = new JLabel();
    private JLabel lbBon = new JLabel("Bonjour, ");
    private JLabel lbNom = new JLabel();
    private JLabel lbMach = new JLabel("<html>Numero de<br>la machine</html>");
    private JLabel lbNumMach = new JLabel();
    private JLabel lbSal = new JLabel("Salle");
    private JLabel lbSalle = new JLabel();
    private JLabel lbDeb = new JLabel("Debut");
    private JLabel lbDebur = new JLabel();
    private JLabel lbF = new JLabel("Fin");
    private JLabel lbFin = new JLabel();

    private JList liste = new JList();

    private JButton btnRetour = new JButton("Retourner");
    private JButton btnGuacamole = new JButton("Acceder Guacamole");
    private JButton btnSupprimer = new JButton("Supprimer reservation");
    private JButton btnReclamer = new JButton("Reclamer");
    private JButton btnActualiser = new JButton("Actualiser");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("ReservationMachine/images/background2.jpg");
    private ImageIcon icon = new ImageIcon("ReservationMachine/images/background2.jpg");
    private Font font = new Font("Arial", Font.BOLD, 36);

    private ReservationMachine[] rm;
    private String[] reserveNom;
    private int courrent;

    private EtudiantControler controler;

    public ConsulterReservationView(EtudiantControler controler) {
        this.controler = controler;
        // retourner toutes les reservations de cet etudiant

        rm = new ReservationMachine[controler.trouverToutesLesReservation(controler.trouverEtudiantId()).length];
        reserveNom = new String[rm.length];
        for (int i = 0; i < controler.trouverToutesLesReservation(controler.trouverEtudiantId()).length; i++) {
            rm[i] = controler.trouverToutesLesReservation(controler.trouverEtudiantId())[i];
        }

        genererNomReservation();


        titre.setFont(font);
        titre.setBounds(390, 20, 300, 40);
        jFrame.setBounds(600, 200, 1010, 550);
        liste = new JList(reserveNom);
        liste.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                courrent = liste.getSelectedIndex();

                lbSalle.setText(rm[courrent].getMachine().getSalle().getNomSalle());
                lbNumMach.setText(rm[courrent].getNomMachine());
                lbDebur.setText(rm[courrent].getHeureDebut().toString());
                lbFin.setText(rm[courrent].getHeureFin().toString());

            }


        });
        liste.setBounds(0, 0, 200, 600);
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
        lbNom.setText(controler.getPrenom());

        lbSal.setBounds(360, 150, 100, 30);
        lbSalle.setBounds(500, 150, 250, 30);
        lbDeb.setBounds(360, 190, 100, 30);
        lbDebur.setBounds(500, 190, 250, 30);
        lbF.setBounds(360, 230, 100, 30);
        lbFin.setBounds(500, 230, 250, 30);
        lbMach.setBounds(360, 270, 100, 30);
        lbNumMach.setBounds(500, 273, 250, 30);
        lbBon.setBounds(700, 80, 70, 20);
        lbNom.setBounds(770, 80, 100, 20);
        lbIMsgC.setForeground(Color.RED);
        lbIMsgC.setBounds(450, 120, 300, 25);
        btnSupprimer.setBounds(360, 400, 180, 30);
        btnGuacamole.setBounds(540, 400, 180, 30);
        btnReclamer.setBounds(720, 400, 180, 30);
        btnRetour.setBounds(800, 470, 100, 20);
        btnActualiser.setBounds(700, 470, 100, 20);
        btnRetour.setBackground(Color.LIGHT_GRAY);


        fieldPanel.add(lbBon);
        fieldPanel.add(titre);
        fieldPanel.add(lbNom);
        fieldPanel.add(lbDeb);
        fieldPanel.add(lbDebur);
        fieldPanel.add(lbSal);
        fieldPanel.add(lbSalle);
        fieldPanel.add(lbF);
        fieldPanel.add(lbFin);
        fieldPanel.add(lbMach);
        fieldPanel.add(lbNumMach);
        fieldPanel.add(liste);
        fieldPanel.add(btnGuacamole);
        fieldPanel.add(btnRetour);
        fieldPanel.add(btnActualiser);
        fieldPanel.add(btnSupprimer);
        fieldPanel.add(btnReclamer);
        fieldPanel.add(lbIMsgC);

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

        btnGuacamole.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                new PageGuacamole();
            }
        });

        btnSupprimer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (controler.supprimerReservation(rm[courrent])) {
                    lbIMsgC.setText("Opération réussie, actualisez, s'il vous plait");

                } else {
                    lbIMsgC.setText("Echec");
                }
            }
        });

        btnActualiser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ConsulterReservationView actualiser = new ConsulterReservationView(controler);
            }
        });
        btnReclamer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new FaireReclamationView(controler, rm[courrent]);
            }
        });
    }

    public void genererNomReservation() {
        for (int i = 0; i < rm.length; i++) {
            reserveNom[i] = ("Reservation" + (i + 1));
            //  System.out.println(reserveNom[i]);
        }
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
