package com.reservationmachines.view.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reservationmachines.controler.AdminControler;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CreerCompteView extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JLabel lbIMsgC = new JLabel();
	private AdminControler controler;
	private JRadioButton btnE = new JRadioButton("Etudiant");
	private JRadioButton btnR = new JRadioButton("RésponsableTP");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public CreerCompteView(AdminControler controler) {
		this.controler = controler;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Création de compte");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(20, 15, 404, 28);
		contentPane.add(lblNewLabel);

		identifiant = new JTextField();
		identifiant.setBounds(147, 69, 147, 21);
		contentPane.add(identifiant);
		identifiant.setColumns(10);

		mdp = new JTextField();
		mdp.setBounds(147, 94, 147, 21);
		contentPane.add(mdp);
		mdp.setColumns(10);

		btnValider = new JButton("Valider");
		btnValider.setBounds(20, 200, 97, 23);
		contentPane.add(btnValider);
		btnValider.addActionListener(this);

		lblNumroEtudient = new JLabel("Numéro");
		lblNumroEtudient.setBounds(20, 72, 173, 15);
		contentPane.add(lblNumroEtudient);

		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(20, 97, 173, 15);
		contentPane.add(lblMotDePasse);
		lbIMsgC.setForeground(Color.RED);
		lbIMsgC.setBounds(450, 85, 200, 25);
		contentPane.add(lbIMsgC);
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 122, 173, 15);
		contentPane.add(lblEmail);

		lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 147, 173, 15);
		contentPane.add(lblNom);

		lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setBounds(20, 172, 173, 15);
		contentPane.add(lblPrenom);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setBounds(127, 200, 97, 23);
		contentPane.add(btnAnnuler);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(147, 119, 147, 21);
		contentPane.add(email);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(147, 144, 147, 21);
		contentPane.add(nom);

		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(147, 169, 147, 21);
		contentPane.add(prenom);

		buttonGroup.add(btnE);
		btnE.setBounds(144, 43, 127, 23);
		contentPane.add(btnE);

		buttonGroup.add(btnR);
		btnR.setBounds(273, 43, 127, 23);
		contentPane.add(btnR);

		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		lblTypeDeCompte.setBounds(20, 47, 173, 15);
		contentPane.add(lblTypeDeCompte);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnValider)) {

			if(buttonGroup.isSelected(btnE.getModel())) {
				controler.creerCompteEtudiant(
						identifiant.getText(),
						mdp.getText(),
						email.getText(),
						nom.getText(),
						prenom.getText()
						);
			}else if(buttonGroup.isSelected(btnR.getModel())) {
				controler.creerCompteResponsableTP(
						identifiant.getText(),
						mdp.getText(),
						email.getText(),
						nom.getText(),
						prenom.getText()
						);
			}
			this.dispose();
			ConsulterCompte cp= new ConsulterCompte(controler);
		}
	}
}
