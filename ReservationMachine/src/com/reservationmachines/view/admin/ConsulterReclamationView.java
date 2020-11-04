package com.reservationmachines.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reservationmachines.controler.AdminControler;

public class ConsulterReclamationView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private AdminControler controler;

	/**
	 * Create the frame.
	 */
	public ConsulterReclamationView(AdminControler controler) {
		this.controler = controler;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultation de la réclamation");
		lblNewLabel.setBounds(10, 10, 220, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 416, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			controler.getReclamation(),
			new String[] {
				"Etudient", "Machine", "Type", "Description"
			}
		));
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}
}
