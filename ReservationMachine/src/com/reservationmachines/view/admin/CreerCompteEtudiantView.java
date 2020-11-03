package com.reservationmachines.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;

public class CreerCompteEtudiantView extends JFrame {

	private JPanel contentPane;
	private JTextField identifiant;
	private JTextField mdp;
	private JLabel lblNumroEtudient;
	private JLabel lblMotDePasse;
	private JLabel lblEmail;
	private JLabel lblNom;
	private JLabel prenom;
	private JButton btnAnnuler;
	private JTextField email;
	private JTextField nom;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerCompteEtudiantView frame = new CreerCompteEtudiantView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreerCompteEtudiantView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9ation de compte \u00E9tudiant");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		lblNewLabel.setBounds(20, 15, 330, 28);
		contentPane.add(lblNewLabel);
		
		identifiant = new JTextField();
		identifiant.setBounds(147, 93, 147, 21);
		contentPane.add(identifiant);
		identifiant.setColumns(10);
		
		mdp = new JTextField();
		mdp.setBounds(147, 118, 147, 21);
		contentPane.add(mdp);
		mdp.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(15, 347, 97, 23);
		contentPane.add(btnValider);
		
		lblNumroEtudient = new JLabel("Num\u00E9ro etudient");
		lblNumroEtudient.setBounds(20, 96, 173, 15);
		contentPane.add(lblNumroEtudient);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(20, 121, 173, 15);
		contentPane.add(lblMotDePasse);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 146, 173, 15);
		contentPane.add(lblEmail);
		
		lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 171, 173, 15);
		contentPane.add(lblNom);
		
		prenom = new JLabel("Pr\u00E9nom");
		prenom.setBounds(20, 196, 173, 15);
		contentPane.add(prenom);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(122, 347, 97, 23);
		contentPane.add(btnAnnuler);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(147, 143, 147, 21);
		contentPane.add(email);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(147, 168, 147, 21);
		contentPane.add(nom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 193, 147, 21);
		contentPane.add(textField_2);
	}
}
