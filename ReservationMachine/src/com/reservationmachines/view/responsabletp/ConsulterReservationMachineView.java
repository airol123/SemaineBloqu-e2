package com.reservationmachines.view.responsabletp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.reservationmachines.controler.ResponsableTPControler;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;

public class ConsulterReservationMachineView extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public ConsulterReservationMachineView(HashMap<String, String> values, ResponsableTPControler controler) {
		setTitle("Consulter les r\u00E9servations des machines");
		getContentPane().setLayout(new BorderLayout());

		JTable table = new JTable(new DefaultTableModel(controler.getValeursReservationMachine(values), controler.getEnteteReservationMachine()));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(BorderLayout.CENTER, scrollPane);

		JLabel lblNewLabel = new JLabel("Liste des machines réservées de la salle " + values.get("nomS"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(BorderLayout.NORTH, lblNewLabel);

		lblNewLabel = new JLabel("Réservation pour le " + values.get("date") + " de " + values.get("heureDebut") + " à " + values.get("heureFin"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(BorderLayout.NORTH, lblNewLabel);

		// Margin autour du label
		Border border = lblNewLabel.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		lblNewLabel.setBorder(new CompoundBorder(border, margin));

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
}
