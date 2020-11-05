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
import com.reservationmachines.view.etudiant.ConsulterReservationView;
import com.reservationmachines.view.main.AdminMainView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsulterReclamationView extends JFrame {
	private JPanel contentPane;
	private JTable table;
	
	private AdminControler controler;
	private JButton btnTraiter;
	private JButton btnRetour;

	/**
	 * Create the frame.
	 */
	public ConsulterReclamationView(AdminControler controler) {
		this.controler = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultation de la réclamation");
		lblNewLabel.setBounds(10, 10, 220, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 566, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			controler.getReclamation(),
			new String[] {
				"Etudient", "Machine", "Type", "Description"
			}
		));
		scrollPane.setViewportView(table);
		
		btnTraiter = new JButton("Traiter");
		btnTraiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controler.traiterReclamation(table.getModel().getValueAt(table.getSelectedColumn()-1, 3).toString());
				table.setModel(new DefaultTableModel(
						controler.getReclamation(),
						new String[] {
							"Etudient", "Machine", "Type", "Description"
						}
					));
			}
		});
		btnTraiter.setBounds(372, 230, 97, 23);
		contentPane.add(btnTraiter);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                AdminMainView am = new AdminMainView(controler);
                am.getjFrame().setVisible(true);
			}
		});
		btnRetour.setBounds(479, 230, 97, 23);
		contentPane.add(btnRetour);
		this.setVisible(true);
	}
}
