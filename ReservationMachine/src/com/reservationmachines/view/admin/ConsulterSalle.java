package com.reservationmachines.view.admin;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.view.main.AdminMainView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsulterSalle extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame = new JFrame("Consultation des salles");
	private JPanel contentPane;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public ConsulterSalle(AdminControler controler) {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 410, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		jFrame.setContentPane(contentPane);


		JLabel lblTitle = new JLabel("Consultation des salles");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 24));
		lblTitle.setBounds(20, 15, 330, 28);
		contentPane.add(lblTitle);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(350, 150);
		scrollPane.setLocation(20, 53);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				controler.getSalle(),
				new String[] {
						"Salle", "Capacit\u00E9"
				}
				));
		scrollPane.setViewportView(table);

		JButton btnConsulter = new JButton("Consulter des machines");
		btnConsulter.setBounds(100, 213, 173, 23);
		contentPane.add(btnConsulter);

		JButton btnAjouter = new JButton("Ajouter une salle");
		btnAjouter.setBounds(100, 246, 173, 23);
		contentPane.add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer une salle");
		btnSupprimer.setBounds(100, 279, 173, 23);
		contentPane.add(btnSupprimer);

		JButton btnRetour = new JButton("Retourner");
		btnRetour.setBounds(295, 298, 93, 23);
		contentPane.add(btnRetour);

		jFrame.setVisible(true);


		//----------------------------listener--------------------------------
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
				new AjouterSalleView(controler);
			}
		});

		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row!=-1) {					
					int capacite = Integer.parseInt((String)table.getValueAt(row , 1));
					if (capacite==0) {
						String nomS = (String)table.getValueAt(row , 0);
						controler.supprimerSalle(nomS);

						table.setModel(new DefaultTableModel(
								controler.getSalle(),
								new String[] {"Salle", "Capacit\u00E9"}
								));		

					} else {
						new AttentionSupprimerSalle();
					}		
				}				
			}
		});

		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
				new AdminMainView(controler);
			}
		});

		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomS = null;
				int row = table.getSelectedRow();
				if (row!=-1) {					
					nomS = (String)table.getValueAt(row , 0);		
				}	
				jFrame.dispose();
				new ConsulterMachine(controler,nomS);	           
			}
		});


	}
}
