package com.reservationmachines.view.responsabletp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class ConsulterReservationSalleView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsulterReservationSalleView frame = new ConsulterReservationSalleView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsulterReservationSalleView() {
		setTitle("Consulter les r\u00E9servations des salles de TP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Listes des salles r\u00E9serv\u00E9es");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		// Margin autour du label
		Border border = lblNewLabel.getBorder();
		Border margin = new EmptyBorder(10, 50, 10, 10);
		lblNewLabel.setBorder(new CompoundBorder(border, margin));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Groupe de TP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);
		
		JComboBox cbFormation = new JComboBox();
		panel_1.add(cbFormation);
		
		JComboBox cbGroupeTP = new JComboBox();
		cbGroupeTP.setEnabled(false);
		panel_1.add(cbGroupeTP);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHoraires = new JLabel("Horaires");
		lblHoraires.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraires.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblHoraires, BorderLayout.NORTH);
	}

}
