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
	private JTable table_1;

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

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		updateTable();

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	protected void updateTable() {
		// Si toutes les valeurs sont renseign�es
		this.table_1 = new JTable(controler.getValeursSallesReservees(), controler.getEnteteSallesReservees());
		// Pour dire que les cellules contenant des boutons doivent afficher le bouton
		this.table_1.getColumn("R�servations machines").setCellEditor(new ButtonEditor(this, controler));
		this.table_1.getColumn("R�servations machines").setCellRenderer(new ButtonRenderer());
		this.table_1.getColumn("Annuler une r�servation").setCellEditor(new ButtonEditor(this, controler));
		this.table_1.getColumn("Annuler une r�servation").setCellRenderer(new ButtonRenderer());
		scrollPane.setViewportView(table_1);
	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	private static final long serialVersionUID = 1L;
	
	// Gestion du comportement de chaque bouton selon sa colonne et sa ligne
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
		this.setText((value != null) ? value.toString() : "");		
		return this;
	}
	
}

class ButtonEditor extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;
	private ResponsableTPControler controler;
	public ConsulterReservationSalleView currentView;
	
	public ButtonEditor(ConsulterReservationSalleView currentView, ResponsableTPControler controler) {
		// Par d�faut, ce type d'objet travaille avec un JCheckBox
		super(new JCheckBox());
		this.currentView = currentView;
		this.controler = controler;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// Cr�ation du bouton
		JButton button = new JButton(table.getValueAt(row, column).toString());
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
	    private JTable table;

	    public void setColumn(int column) {this.column = column;}
	    public void setRow(int row) {this.row = row;}
	    public void setTable(JTable table) {this.table = table;}

	    public void actionPerformed(ActionEvent event) {
	    	// Affectation du comportement appropri� � chaque bouton
	    	// En fonction de la colonne et de la ligne
			if(column == 8) {
				new ConsulterReservationMachineView(table.getValueAt(row, 6).toString(), controler);
			} else if(column == 9) {	
				HashMap<String, String> values = new HashMap<String, String>();
				values.put("strHeureDebut", table.getValueAt(row, 4).toString());
				values.put("strDate", table.getValueAt(row, 3).toString());
				values.put("nomSalle", table.getValueAt(row, 6).toString());
				values.put("nomGroupeTP", table.getValueAt(row, 2).toString());
				values.put("nomFormation", table.getValueAt(row, 1).toString());
				
				new AnnulerReservationSalleView(values, currentView, table.getValueAt(row, 6).toString(), controler);
			}
	    }
	}

}

