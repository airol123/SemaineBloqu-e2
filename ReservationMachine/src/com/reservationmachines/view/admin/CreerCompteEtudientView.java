package com.reservationmachines.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reservationmachines.controler.AdminControler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreerCompteEtudientView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField identifiant;
	private JTextField mdp;
	private JLabel lblNumroEtudient;
	private JLabel lblMotDePasse;
	private JLabel lblEmail;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JTextField email;
	private JTextField nom;
	private JTextField prenom;

	private AdminControler controler;
	
	/**
	 * Create the frame.
	 */
	public CreerCompteEtudientView(AdminControler controler) {
		this.controler = controler;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Création de compte étudient");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(20, 15, 404, 28);
		contentPane.add(lblNewLabel);
		
		identifiant = new JTextField();
		identifiant.setBounds(147, 53, 147, 21);
		contentPane.add(identifiant);
		identifiant.setColumns(10);
		
		mdp = new JTextField();
		mdp.setBounds(147, 78, 147, 21);
		contentPane.add(mdp);
		mdp.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(20, 200, 97, 23);
		contentPane.add(btnValider);
		btnValider.addActionListener(this);
		
		lblNumroEtudient = new JLabel("Numéro");
		lblNumroEtudient.setBounds(20, 56, 173, 15);
		contentPane.add(lblNumroEtudient);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(20, 81, 173, 15);
		contentPane.add(lblMotDePasse);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 106, 173, 15);
		contentPane.add(lblEmail);
		
		lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 131, 173, 15);
		contentPane.add(lblNom);
		
		lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(20, 156, 173, 15);
		contentPane.add(lblPrenom);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(127, 200, 97, 23);
		contentPane.add(btnAnnuler);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(147, 103, 147, 21);
		contentPane.add(email);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(147, 128, 147, 21);
		contentPane.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(147, 153, 147, 21);
		contentPane.add(prenom);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnValider)) {
			controler.creerCompteEtudiant(
				identifiant.getText(),
				mdp.getText(),
				email.getText(),
				nom.getText(),
				prenom.getText()
			);
		}
		if(e.getSource().equals(btnAnnuler)) {
			this.dispose();
		}
	}
}
