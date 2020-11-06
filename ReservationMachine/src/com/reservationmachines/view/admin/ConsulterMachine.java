package com.reservationmachines.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.view.main.AdminMainView;

public class ConsulterMachine extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private AdminControler controler;

	public ConsulterMachine(AdminControler controler, String nomS) {
		this.controler = controler;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultation des machines");
		lblNewLabel.setBounds(10, 10, 220, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 566, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			controler.getMachine(nomS),
			new String[] {"Salle", "Machine", "Etat"}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAjouter = new JButton("Ajouter une machine");
		btnAjouter.setBounds(206, 232, 173, 23);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer une machine");
		btnSupprimer.setBounds(389, 232, 173, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnRetour = new JButton("Retourner");
		btnRetour.setBounds(492, 270, 93, 23);
		contentPane.add(btnRetour);
		
		JButton btnReservation = new JButton("R\u00E9servations");
		btnReservation.setBounds(20, 232, 173, 23);
		contentPane.add(btnReservation);
		
		this.setVisible(true);
		
	
		//----------------------------listener--------------------------------
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            dispose();
	            new AjouterMachineSalleView(controler);
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row!=-1) {					
					String nomM = (String)table.getValueAt(row , 1);
					controler.supprimerMachine(nomM);
					table.setModel(new DefaultTableModel(
							controler.getMachine(nomS),
							new String[] {"Salle", "Machine", "Etat"}
						));
				}				
			}
		});
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            dispose();
	            new AdminMainView(controler);
			}
		});
		
	}

}
