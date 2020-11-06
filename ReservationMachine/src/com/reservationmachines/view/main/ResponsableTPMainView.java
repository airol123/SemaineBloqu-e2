package com.reservationmachines.view.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reservationmachines.controler.ResponsableTPControler;
import com.reservationmachines.main.AppMain;
import com.reservationmachines.view.responsabletp.ConsulterReservationSalleView;
import com.reservationmachines.view.responsabletp.ReserverSalleView;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ResponsableTPMainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsulterLesSalles;
	private JButton btnReserverUneNouvelle;

	private ResponsableTPControler controler;
	private JButton btnDeconnexion;
	private JLabel lblBonjour;

	/**
	 * Create the frame.
	 */
	public ResponsableTPMainView(ResponsableTPControler controler) {
		this.controler = controler;

		setTitle("Interface principale - ResponsableTP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{138, 0, 199, 161, 0, 0};
		gbl_contentPane.rowHeights = new int[]{56, 7, 0, 19, 50, -37, 50, 0, 0, -34, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Responsable de TP");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		btnReserverUneNouvelle = new JButton("R\u00E9server une nouvelle salle");
		GridBagConstraints gbc_btnRserverUneNouvelle = new GridBagConstraints();
		gbc_btnRserverUneNouvelle.fill = GridBagConstraints.BOTH;
		gbc_btnRserverUneNouvelle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRserverUneNouvelle.gridx = 2;
		gbc_btnRserverUneNouvelle.gridy = 6;
		btnReserverUneNouvelle.addActionListener(this);

		lblBonjour = new JLabel("Bonjour " + this.controler.getPrenom() + " !");
		lblBonjour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBonjour = new GridBagConstraints();
		gbc_lblBonjour.gridwidth = 5;
		gbc_lblBonjour.insets = new Insets(0, 0, 5, 5);
		gbc_lblBonjour.gridx = 0;
		gbc_lblBonjour.gridy = 1;
		contentPane.add(lblBonjour, gbc_lblBonjour);

		btnConsulterLesSalles = new JButton("Consulter les salles r\u00E9serv\u00E9es");
		GridBagConstraints gbc_btnConsulterLesSalles = new GridBagConstraints();
		gbc_btnConsulterLesSalles.fill = GridBagConstraints.BOTH;
		gbc_btnConsulterLesSalles.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsulterLesSalles.gridx = 2;
		gbc_btnConsulterLesSalles.gridy = 4;
		contentPane.add(btnConsulterLesSalles, gbc_btnConsulterLesSalles);
		btnConsulterLesSalles.addActionListener(this);
		contentPane.add(btnReserverUneNouvelle, gbc_btnRserverUneNouvelle);

		btnDeconnexion = new JButton("D\u00E9connexion");
		GridBagConstraints gbc_btnDconnexion = new GridBagConstraints();
		gbc_btnDconnexion.insets = new Insets(0, 0, 5, 5);
		gbc_btnDconnexion.fill = GridBagConstraints.BOTH;
		gbc_btnDconnexion.gridx = 3;
		gbc_btnDconnexion.gridy = 8;
		contentPane.add(btnDeconnexion, gbc_btnDconnexion);
		btnDeconnexion.addActionListener(this);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnConsulterLesSalles)) {
			new ConsulterReservationSalleView(controler);
		} else if (e.getSource().equals(btnReserverUneNouvelle)) {
			new ReserverSalleView(controler);
		} else if (e.getSource().equals(btnDeconnexion)) {
			controler.deconnexion();
			this.dispose();
			new AppMain();
		}
	}

}
