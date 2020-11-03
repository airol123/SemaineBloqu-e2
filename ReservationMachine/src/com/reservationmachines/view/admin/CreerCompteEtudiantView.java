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

public class CreerCompteEtudiantView extends JFrame {

	private JPanel contentPane;
	private JTextField identifiant;
	private JTextField mdp;

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
		lblNewLabel.setBounds(20, 15, 173, 15);
		contentPane.add(lblNewLabel);
		
		identifiant = new JTextField();
		identifiant.setBounds(17, 151, 66, 21);
		contentPane.add(identifiant);
		identifiant.setColumns(10);
		
		mdp = new JTextField();
		mdp.setBounds(18, 181, 66, 21);
		contentPane.add(mdp);
		mdp.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(15, 347, 97, 23);
		contentPane.add(btnValider);
	}
}
