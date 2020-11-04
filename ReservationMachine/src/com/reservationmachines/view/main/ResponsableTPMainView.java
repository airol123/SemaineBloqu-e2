package com.reservationmachines.view.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reservationmachines.controler.ResponsableTPControler;
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

	/**
	 * Create the frame.
	 */
	public ResponsableTPMainView(ResponsableTPControler controler) {
		this.controler = controler;
		
		setTitle("Interface principale - ResponsableTP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{138, 199, 161, 0};
		gbl_contentPane.rowHeights = new int[]{56, 13, 37, 0, 33, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Responsable de TP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		btnConsulterLesSalles = new JButton("Consulter les salles r\u00E9serv\u00E9es");
		GridBagConstraints gbc_btnConsulterLesSalles = new GridBagConstraints();
		gbc_btnConsulterLesSalles.fill = GridBagConstraints.BOTH;
		gbc_btnConsulterLesSalles.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsulterLesSalles.gridx = 1;
		gbc_btnConsulterLesSalles.gridy = 2;
		contentPane.add(btnConsulterLesSalles, gbc_btnConsulterLesSalles);
		btnConsulterLesSalles.addActionListener(this);
		
		btnReserverUneNouvelle = new JButton("R\u00E9server une nouvelle salle");
		GridBagConstraints gbc_btnRserverUneNouvelle = new GridBagConstraints();
		gbc_btnRserverUneNouvelle.fill = GridBagConstraints.BOTH;
		gbc_btnRserverUneNouvelle.insets = new Insets(0, 0, 0, 5);
		gbc_btnRserverUneNouvelle.gridx = 1;
		gbc_btnRserverUneNouvelle.gridy = 4;
		btnReserverUneNouvelle.addActionListener(this);
		contentPane.add(btnReserverUneNouvelle, gbc_btnRserverUneNouvelle);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnConsulterLesSalles)) {
			new ConsulterReservationSalleView(controler);
			this.dispose();
		} else if (e.getSource().equals(btnReserverUneNouvelle)) {
			new ReserverSalleView(controler);
			this.dispose();
		}
	}

}
