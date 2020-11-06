package com.reservationmachines.view.responsabletp;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import com.reservationmachines.controler.ResponsableTPControler;

import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ConsulterReservationSalleView extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JTable table;

	private ResponsableTPControler controler;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 * @param controler 
	 */
	public ConsulterReservationSalleView(ResponsableTPControler controler) {
		this.controler = controler;

		setTitle("Consulter ses r\u00E9servations de salle(s)");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Liste des salles de TP r\u00E9serv\u00E9es");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 17;
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		updateTable();

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	protected void updateTable() {
		// Si toutes les valeurs sont renseign�es
		this.table = new JTable(controler.getValeursSallesReservees(), controler.getEnteteSallesReservees());
		// Pour dire que les cellules contenant des boutons doivent afficher le bouton
		this.table.getColumn("Réservations machines").setCellEditor(new ButtonEditor(this, controler));
		this.table.getColumn("Réservations machines").setCellRenderer(new ButtonRenderer());
		this.table.getColumn("Annuler une réservation").setCellEditor(new ButtonEditor(this, controler));
		this.table.getColumn("Annuler une réservation").setCellRenderer(new ButtonRenderer());
		scrollPane.setViewportView(table);
	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	private static final long serialVersionUID = 1L;

	// Gestion du comportement de chaque bouton selon sa colonne et sa ligne
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
		if(col == 8) this.setText("Voir l'état des machines");
		else if(col == 9) this.setText("Annuler");

		return this;
	}

}

class ButtonEditor extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;
	private ResponsableTPControler controler;
	public ConsulterReservationSalleView currentView;

	public ButtonEditor(ConsulterReservationSalleView currentView, ResponsableTPControler controler) {
		// Par défaut, ce type d'objet travaille avec un JCheckBox
		super(new JCheckBox());
		this.currentView = currentView;
		this.controler = controler;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// Cr�ation du bouton
		JButton button = null;

		if(column == 8) button = new JButton("Voir l'état des machines");
		else if(column == 9)  button = new JButton("Annuler");

		button.setOpaque(true);

		// Cr�ation du listener
		ButtonListener bl = new ButtonListener();	
		bl.setRow(row);
		bl.setColumn(column);
		bl.setTable(table);

		// Affectation du listener au bouton
		button.addActionListener(bl);

		return button;
	}

	class ButtonListener implements ActionListener{        
		private int column, row;
		private JTable myTable;

		public void setColumn(int column) {this.column = column;}
		public void setRow(int row) {this.row = row;}
		public void setTable(JTable table) {this.myTable = table;}

		public void actionPerformed(ActionEvent event) {
			// Affectation du comportement appropri� � chaque bouton
			// En fonction de la colonne et de la ligne
			if(column == 8) {
				HashMap<String, String> values = new HashMap<String, String>();
				values.put("nomS", myTable.getValueAt(row, 6).toString());
				values.put("heureDebut", currentView.table.getValueAt(row, 4).toString());
				values.put("heureFin", currentView.table.getValueAt(row, 5).toString());
				values.put("date", currentView.table.getValueAt(row, 3).toString());

				new ConsulterReservationMachineView(values, controler);
			} else if(column == 9) {	
				HashMap<String, String> values = new HashMap<String, String>();
				values.put("strHeureDebut", myTable.getValueAt(row, 4).toString());
				values.put("strDate", myTable.getValueAt(row, 3).toString());
				values.put("nomSalle", myTable.getValueAt(row, 6).toString());
				values.put("nomGroupeTP", myTable.getValueAt(row, 2).toString());
				values.put("nomFormation", myTable.getValueAt(row, 1).toString());

				new AnnulerReservationSalleView(values, currentView, myTable.getValueAt(row, 6).toString(), controler);
			}
		}
	}

}

