package com.reservationmachines.view.etudiant;

import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.model.Reclamation;
import com.reservationmachines.model.ReservationMachine;
import com.reservationmachines.model.TypeReclamation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FaireReclamationView {
    private JFrame jFrame = new JFrame("Reclamation");
    private Container c = jFrame.getContentPane();
    private JLabel titre = new JLabel("Reclamation");
    private JLabel lbType = new JLabel("Type de reclamation");
    private JLabel lbDescri = new JLabel("Description");
    private JTextField descri =new JTextField(400);
    private JButton btnVlider = new JButton("Reclamer");
    private JButton btnretourner = new JButton("retourner");
    String[] typeR = new String[]{"En panne", "Déjà réservée"};

    final JComboBox<String> comboBox = new JComboBox<String>(typeR);

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);
    private ReservationMachine rm;
	protected EtudiantControler controler;

    public FaireReclamationView(EtudiantControler controler, ReservationMachine rm) {
        this.controler = controler;
        this.rm=rm;
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
        lbType.setBounds(340,150,150,30);
        lbDescri.setBounds(340,190,100,30);
        descri.setBounds(340,240,340,100);
        btnretourner.setBounds(580,380,100,30);
        btnVlider.setBounds(340,380,100,30);
        comboBox.setBounds(530,150,150,25);
        fieldPanel.add(titre);
        fieldPanel.add(lbDescri);
        fieldPanel.add(lbType);
        fieldPanel.add(descri);
        fieldPanel.add(btnVlider);
        fieldPanel.add(btnretourner);
        fieldPanel.add(comboBox);
        fieldPanel.add(lblBackground);
        c.add(fieldPanel, "Center");



        //----------------------------listener--------------------------------

        btnretourner.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                ConsulterReservationView pe = new ConsulterReservationView(controler);
                pe.getjFrame().setVisible(true);

            }
        });

        btnVlider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String strDes=descri.getText();
                TypeReclamation ty;
                //String t=comboBox.getSelectedItem().toString();
                int index=comboBox.getSelectedIndex();
                if (index==1){
                     ty = TypeReclamation.Deja_reserve;
                }else{
                     ty = TypeReclamation.En_panne;
                }
                Reclamation re = new Reclamation(ty,strDes,rm);
                controler.stockerReclamation(re);
            }
        });

    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
