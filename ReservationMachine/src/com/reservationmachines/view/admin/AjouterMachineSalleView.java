package com.reservationmachines.view.admin;

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
import javax.swing.JComboBox;

public class AjouterMachineSalleView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JLabel lblNumroEtudient;
	private JLabel lblMotDePasse;
	private JButton btnAnnuler;
	private JButton btnValider;
	private JComboBox<String> cbSalle;
	
	private AdminControler controler;


	/**
	 * Create the frame.
	 */
	public AjouterMachineSalleView(AdminControler controler) {
		this.controler = controler;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajout de la machine");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(20, 15, 330, 28);
		contentPane.add(lblNewLabel);
		
		nom = new JTextField();
		nom.setBounds(147, 53, 147, 21);
		contentPane.add(nom);
		nom.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(20, 121, 97, 23);
		contentPane.add(btnValider);
		btnValider.addActionListener(this);
		
		lblNumroEtudient = new JLabel("Nom de machine");
		lblNumroEtudient.setBounds(20, 56, 173, 15);
		contentPane.add(lblNumroEtudient);
		
		lblMotDePasse = new JLabel("Salle");
		lblMotDePasse.setBounds(20, 81, 97, 15);
		contentPane.add(lblMotDePasse);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ConsulterMachine(controler,null);	
			}
		});
		btnAnnuler.setBounds(127, 121, 97, 23);
		contentPane.add(btnAnnuler);
		
		cbSalle = new JComboBox<String>(controler.getListeNomSalle());
		cbSalle.setBounds(147, 77, 147, 23);
		contentPane.add(cbSalle);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnValider)) {
			controler.ajouterMachineSalle(
				nom.getText(), (String)cbSalle.getSelectedItem()
			);
			this.dispose();
			new ConsulterMachine(controler, null);
		}
		if(e.getSource().equals(btnAnnuler)) {
			this.dispose();			
		}
		
	}
}
