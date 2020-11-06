package com.reservationmachines.view.admin;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttentionSupprimerSalle extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame = new JFrame("Attention");
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AttentionSupprimerSalle() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		jFrame.setContentPane(contentPane);

		JLabel lblTitle = new JLabel("<html>Vueillez d'abord supprimer tous les <br> machines dans la salle<html>");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTitle.setBounds(20, 30, 330, 80);
		contentPane.add(lblTitle);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
			}
		});
		btnNewButton.setBounds(148, 120, 93, 23);
		contentPane.add(btnNewButton);

		jFrame.setVisible(true);
	}
}
