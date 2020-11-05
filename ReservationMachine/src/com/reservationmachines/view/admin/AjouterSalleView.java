package com.reservationmachines.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import com.reservationmachines.controler.AdminControler;
import java.awt.event.ActionEvent;

public class AjouterSalleView extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JLabel lblTitle;
	private JTextField nomS;
	private JLabel lblNomSalle;
	private JTextField capacite;
	private JLabel lblCapacite;
	private JButton btnValider;
	private JButton btnAnnuler;
	
	private AdminControler controler;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AjouterSalleView frame = new AjouterSalleView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AjouterSalleView() {
	
		this.controler = controler;
		this.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Ajout de la salle");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 24));
		lblTitle.setBounds(20, 15, 330, 28);
		contentPane.add(lblTitle);
		
		lblNomSalle = new JLabel("Nom de salle");
		lblNomSalle.setBounds(20, 70, 173, 15);
		contentPane.add(lblNomSalle);
		
		nomS = new JTextField();
		nomS.setBounds(147, 67, 147, 21);
		contentPane.add(nomS);
		nomS.setColumns(10);
		
//		lblCapacite = new JLabel("Capacité");
//		lblCapacite.setBounds(20, 81, 97, 15);
//		contentPane.add(lblCapacite);
//		
//		capacite = new JTextField();
//		capacite.setBounds(147, 77, 147, 23);
//		contentPane.add(capacite);		
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(20, 121, 97, 23);
		contentPane.add(btnValider);
		btnValider.addActionListener(this);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(127, 121, 97, 23);
		contentPane.add(btnAnnuler);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnValider)) {
			controler.ajouterSalle(nomS.getText());
			this.dispose();
		}
		if(e.getSource().equals(btnAnnuler)) {
			this.dispose();
		}
	}
}
