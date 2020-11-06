package com.reservationmachines.view.admin;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import com.reservationmachines.controler.AdminControler;
import java.awt.event.ActionEvent;

public class AjouterSalleView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame = new JFrame("Consultation des salles");
	private JPanel contentPane;
	private JLabel lblTitle;
	private JTextField nomS;
	private JLabel lblNomSalle;
	private JButton btnValider;
	private JButton btnAnnuler;


	public AjouterSalleView(AdminControler controler) {

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 391, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jFrame.setContentPane(contentPane);
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

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(127, 121, 97, 23);
		contentPane.add(btnAnnuler);

		jFrame.setVisible(true);


		//----------------------------listener--------------------------------
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.ajouterSalle(nomS.getText());
				jFrame.dispose();
				new ConsulterSalle(controler);
			}
		});

		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
				new ConsulterSalle(controler);
			}
		});

	}

	//	public void actionPerformed(ActionEvent e) {
	//		if(e.getSource().equals(btnValider)) {
	//			controler.ajouterSalle(nomS.getText());
	//			this.dispose();
	//		}
	//		if(e.getSource().equals(btnAnnuler)) {
	//			this.dispose();
	//		}
	//	}

}
