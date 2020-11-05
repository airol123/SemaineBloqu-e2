package com.reservationmachines.view.admin;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.view.main.AdminMainView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

public class ConsulterCompte extends JFrame {
    private JPanel contentPane;
    private JTable table;

    private AdminControler controler;
    private JButton btnAjouter;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JButton btnRetour;
    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("ReservationMachine/images/background2.jpg");
    private ImageIcon icon = new ImageIcon("ReservationMachine/images/background2.jpg");

    /**
     * Create the frame.
     */
    public ConsulterCompte(AdminControler controler) {
        this.controler = controler;
        this.setLayout(null);
        this.setTitle("gestion de compte");
        lblBackground.setIcon(icon); // Définir l'icône à afficher par le composant d'étiquette
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Consultation des Comptes");
        lblNewLabel.setBounds(50, 10, 220, 15);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 42, 566, 350);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                controler.getCompteE(),
                new String[] {
                        "Tpye", "Identifiant", "Nom", "Prenom"
                }
        ));
        scrollPane.setViewportView(table);

        btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CreerCompteView am = new CreerCompteView(controler);
                am.setVisible(true);
            }
        });
        btnAjouter.setBounds(50, 400, 100, 23);
        contentPane.add(btnAjouter);


        btnModifier = new JButton("Modifier");
        btnModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                ModifierCompteView mce = new ModifierCompteView(controler);
                mce.getjFrame().setVisible(true);
            }
        });
        btnModifier.setBounds(170, 400, 100, 23);
        contentPane.add(btnModifier);


        btnSupprimer = new JButton("Supprimer");
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        btnSupprimer.setBounds(290, 400, 100, 23);
        contentPane.add(btnSupprimer);



        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                AdminMainView am = new AdminMainView(controler);
                am.getjFrame().setVisible(true);
            }
        });
        btnRetour.setBounds(515, 400, 100, 23);
        btnRetour.setBackground(Color.lightGray);
        contentPane.add(btnRetour);

        contentPane.add(lblBackground);
        this.setVisible(true);
    }
}