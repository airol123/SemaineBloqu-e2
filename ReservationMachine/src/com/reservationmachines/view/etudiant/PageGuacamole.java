package com.reservationmachines.view.etudiant;


import java.awt.*;
import java.io.*;

import javax.swing.*;

public class PageGuacamole {
	private JEditorPane jep = new JEditorPane();



	private JFrame frame = new JFrame("Guacamole");
	public PageGuacamole()  {


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createUI(frame);
		frame.setSize(1200, 900);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public JFrame getFrame() {
		return frame;
	}
	private static void createUI(final JFrame frame){
		JPanel panel = new JPanel();
		LayoutManager layout = new FlowLayout();
		panel.setLayout(layout);

		JEditorPane jEditorPane = new JEditorPane();
		jEditorPane.setEditable(false);
		try {
			//jEditorPane.setPage("https://guacamole.ut-capitole.fr/#/");
			jEditorPane.setPage("https://www.google.fr/");
		} catch (IOException e) {
			jEditorPane.setContentType("text/html");
			jEditorPane.setText("<html>Page not found.</html>");
		}

		JScrollPane jScrollPane = new JScrollPane(jEditorPane);
		jScrollPane.setPreferredSize(new Dimension(1200,900));

		panel.add(jScrollPane);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
}