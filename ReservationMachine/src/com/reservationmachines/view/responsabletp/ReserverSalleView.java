package com.reservationmachines.view.responsabletp;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.reservationmachines.controler.ResponsableTPControler;

public class ReserverSalleView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> cbFormation;
	private JComboBox<String> cbGroupeTP;
	private JComboBox<String> cbHeureDebut;
	private JComboBox<String> cbDate;
	private JComboBox<String> cbHeureFin;

	private ResponsableTPControler controler;
	
	/**
	 * Create the frame.
	 */
	public ReserverSalleView(ResponsableTPControler controler) {
		this.controler = controler;
		
		setTitle("Consulter les r\u00E9servations des salles de TP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{133, 0};
		gbl_contentPane.rowHeights = new int[]{37, 296, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Listes des salles r\u00E9serv\u00E9es");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{219, 406, 0};
		gbl_panel.rowHeights = new int[]{136, 160, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{215, 0, 0};
		gbl_panel_1.rowHeights = new int[]{60, 34, 30, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Groupe de TP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cbFormation = new JComboBox<String>(controler.recupererFormations());
		GridBagConstraints gbc_cbFormation = new GridBagConstraints();
		gbc_cbFormation.gridwidth = 2;
		gbc_cbFormation.fill = GridBagConstraints.BOTH;
		gbc_cbFormation.insets = new Insets(0, 0, 5, 5);
		gbc_cbFormation.gridx = 0;
		gbc_cbFormation.gridy = 1;
		panel_1.add(cbFormation, gbc_cbFormation);
		cbFormation.addActionListener(this);
		
		String currentFormation = cbFormation.getSelectedItem().toString();
		cbGroupeTP = new JComboBox<String>(controler.recupererGroupeTP(currentFormation));
		GridBagConstraints gbc_cbGroupeTP = new GridBagConstraints();
		gbc_cbGroupeTP.gridwidth = 2;
		gbc_cbGroupeTP.insets = new Insets(0, 0, 0, 5);
		gbc_cbGroupeTP.fill = GridBagConstraints.BOTH;
		gbc_cbGroupeTP.gridx = 0;
		gbc_cbGroupeTP.gridy = 2;
		panel_1.add(cbGroupeTP, gbc_cbGroupeTP);
		cbGroupeTP.addActionListener(this);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 2;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{137, 149, 119, 0};
		gbl_panel_3.rowHeights = new int[]{61, 234, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Liste des salles disponibles");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{128, 113, 0};
		gbl_panel_2.rowHeights = new int[]{60, 34, 34, 30, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblHoraires = new JLabel("Horaires");
		lblHoraires.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraires.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GridBagConstraints gbc_lblHoraires = new GridBagConstraints();
		gbc_lblHoraires.gridwidth = 2;
		gbc_lblHoraires.insets = new Insets(0, 0, 5, 0);
		gbc_lblHoraires.fill = GridBagConstraints.BOTH;
		gbc_lblHoraires.gridx = 0;
		gbc_lblHoraires.gridy = 0;
		panel_2.add(lblHoraires, gbc_lblHoraires);
		
		cbHeureDebut = new JComboBox<String>(controler.getReservationsSallesHeuresDebuts());
		GridBagConstraints gbc_cbHeureDebut = new GridBagConstraints();
		gbc_cbHeureDebut.insets = new Insets(0, 0, 5, 0);
		gbc_cbHeureDebut.fill = GridBagConstraints.BOTH;
		gbc_cbHeureDebut.gridx = 1;
		gbc_cbHeureDebut.gridy = 1;
		panel_2.add(cbHeureDebut, gbc_cbHeureDebut);
		cbHeureDebut.addActionListener(this);
		
		cbDate = new JComboBox<String>(controler.getReservationsSallesDates());
		GridBagConstraints gbc_cbDate = new GridBagConstraints();
		gbc_cbDate.insets = new Insets(0, 0, 5, 5);
		gbc_cbDate.fill = GridBagConstraints.BOTH;
		gbc_cbDate.gridx = 0;
		gbc_cbDate.gridy = 2;
		panel_2.add(cbDate, gbc_cbDate);
		cbDate.addActionListener(this);
		
		cbHeureFin = new JComboBox<String>(controler.getReservationsSallesHeuresFins());
		GridBagConstraints gbc_cbHeureFin = new GridBagConstraints();
		gbc_cbHeureFin.fill = GridBagConstraints.BOTH;
		gbc_cbHeureFin.gridx = 1;
		gbc_cbHeureFin.gridy = 3;
		panel_2.add(cbHeureFin, gbc_cbHeureFin);
		cbHeureFin.addActionListener(this);
		
		updateJTable();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cbFormation)) {
			String currentFormation = cbFormation.getSelectedItem().toString();
			cbGroupeTP.setModel(new DefaultComboBoxModel<String>(controler.recupererGroupeTP(currentFormation)));
		} else if(e.getSource().equals(cbDate)) {
			updateJTable();
		} else if(e.getSource().equals(cbHeureDebut)) {
			updateJTable();
			String currentHeureDebut = cbHeureDebut.getSelectedItem().toString();
			String currentHeureFin = cbHeureFin.getSelectedItem().toString();
			
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(controler.getReservationsSallesHeuresFins(currentHeureDebut));
			if(model.getIndexOf(currentHeureFin) != -1) model.setSelectedItem(currentHeureFin);
			cbHeureFin.setModel(model);
		} else if(e.getSource().equals(cbHeureFin)) {
			//updateJTable();
			String currentHeureDebut = cbHeureDebut.getSelectedItem().toString();
			String currentHeureFin = cbHeureFin.getSelectedItem().toString();

			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(controler.getReservationsSallesHeuresDebuts(currentHeureFin));
			if(model.getIndexOf(currentHeureDebut) != -1) model.setSelectedItem(currentHeureDebut);
			cbHeureDebut.setModel(model);
		}
	}

	public void updateJTable() {
		String date = formatSQLDate(cbDate.getSelectedItem().toString());
		String heureDebut = cbHeureDebut.getSelectedItem().toString();
		String heureFin = cbHeureFin.getSelectedItem().toString();
		
		// Si toutes les valeurs sont renseignées
		if(!(date.equals("") && heureDebut.equals("") && heureFin.equals(""))) {
			this.table.setModel(
				new DefaultTableModel(
					controler.getValeursSallesDisponibles(date, heureDebut, heureFin),
					controler.getEnteteSallesDisponibles()
				)
			);
		}
	}
	
	/**
	 * Convertit une date "EEE dd/MM/yyyy" en "dd/MM/yyyy"
	 * @param date
	 * @return
	 */
	public String formatSQLDate(String date) {
		// Suppression du jour
		date = date.substring(5);
		
		// Récupération des données de la date
		String jour = date.split("/")[0];
		String mois = date.split("/")[1];
		String annee = date.split("/")[2];
		
		// Raccord avant return pour avoir le format AAAA-MM-JJ
        return String.join("-", new String[] {annee, mois, jour});
	}
}
