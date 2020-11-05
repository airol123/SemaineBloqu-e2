package com.reservationmachines.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.main.AppMain;
import com.reservationmachines.view.admin.ConsulterReclamationView;
import com.reservationmachines.view.admin.AjouterMachineSalleView;
import com.reservationmachines.view.admin.ConsulterCompte;
import com.reservationmachines.view.admin.ConsulterSalle;


public class AdminMainView {
	private JFrame jFrame = new JFrame("Page Personnelle");
	private Container c = jFrame.getContentPane();
	
	private JLabel titre = new JLabel("Page Personnelle");
	private JLabel lbBon = new JLabel("Bonjour, ");
	private JLabel lbNom=new JLabel() ;
	
	private JButton btnReclamation = new JButton("Gestion de réclamation");
	private JButton btnCompte = new JButton("Gestion de compte");
	private JButton btnMachine = new JButton("Gestion de machine");
	private JButton btndeconnec = new JButton("Se déconnecter");
	private JButton btnSalle = new JButton("Gestion de salle");
	// background && font
	private JLabel lblBackground = new JLabel();
	private URL resource = this.getClass().getResource("ReservationMachine/images/background2.jpg");
	private ImageIcon icon = new ImageIcon("ReservationMachine/images/background2.jpg");
	private Font font = new Font("Arial",Font.BOLD,36);
	private AdminControler controler;
	
	public AdminMainView(AdminControler controler) { //
	    this.controler = controler;
	
	    titre.setFont(font);
	    titre.setBounds(390,20,300,40);
	    jFrame.setBounds(600, 200, 1010, 550);
	    //Mettre en place une couche de quelque chose d'équivalent à une nappe
	    c.setLayout(new BorderLayout());//Gestionnaire de mise en page
	    //Définir pour fermer après avoir appuyé sur le chiffre X dans le coin supérieur droit
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setLocationRelativeTo(null);
	    //Initialisation-mettre d'autres contrôles dans le formulaire
	    init();
	    //Définir le formulaire pour qu'il soit visible
	    jFrame.setVisible(true);
	}
	public void init() {
	    lblBackground.setIcon(icon); // Définir l'icône à afficher par le composant d'étiquette
	    lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
	
	    JPanel fieldPanel = new JPanel();
	    fieldPanel.setLayout(null);
	
	    btnCompte.setBounds(410,150,250,50);
	    btnMachine.setBounds(410,220,250,50);
	    btnReclamation.setBounds(410,363,250,50);
	    btndeconnec.setBounds(740,440,200,30);
	    btndeconnec.setBackground(Color.LIGHT_GRAY);
	    btnSalle.setBounds(410, 291, 250, 50);
	    lbBon.setBounds(700,80,50,20);
	    lbNom.setBounds(750,80,100,20);
	    fieldPanel.add(titre);
	    fieldPanel.add(lbBon);
	    fieldPanel.add(lbNom);
	    fieldPanel.add(btnCompte);
	    fieldPanel.add(btnMachine);
	    fieldPanel.add(btndeconnec);
	    fieldPanel.add(btnReclamation);
	    fieldPanel.add(btnSalle);
	    fieldPanel.add(lblBackground);
	
	    lbNom.setText(controler.getPrenom());
	
	    c.add(fieldPanel, "Center");
	    
	    
	    
	
	    //----------------------------listener--------------------------------
	    btndeconnec.addActionListener(new ActionListener() {
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jFrame.dispose();
	            controler.deconnexion();
	            new AppMain();
	        }
	    });
	
	    btnCompte.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            jFrame.dispose();
				ConsulterCompte cc =new ConsulterCompte(controler);
				cc.setVisible(true);
	            //
	        }
	    });
	
	    btnMachine.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            jFrame.dispose();
	        }
	    });
	    
	    btnSalle.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		jFrame.dispose();
	    		new ConsulterSalle(controler);
	    	}
	    });
	
	    btnReclamation.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	            jFrame.dispose();
	            new ConsulterReclamationView(controler);
	            //
	        }
	    });
	
	
	
	}
	public JFrame getjFrame() {
	    return jFrame;
		}
}
