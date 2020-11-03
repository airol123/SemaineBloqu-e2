package com.reservationmachines.view.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.controler.ResponsableTPControler;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.view.etudiant.Inscription;
import com.reservationmachines.view.etudiant.PageEtudiant;

public class SeConnecterView {

	private JFrame jFrame = new JFrame("Connexion");
    private Container c = jFrame.getContentPane();

    private JLabel titre = new JLabel("Connexion");
    private JLabel lbIMsgI = new JLabel();
    private JLabel lbUser = new JLabel("Indentifiant");
    private JTextField username = new JTextField();
    private JLabel lbPass = new JLabel("Mot de passe");
    private JPasswordField password = new JPasswordField();
    private JButton okbtn = new JButton("Valider");
    private JButton cancelbtn = new JButton("Annuler");
    private JButton inscription = new JButton("S'inscrire");
    private JRadioButton radioBtn1 = new JRadioButton("Etudient");
    private JRadioButton radioBtn2 = new JRadioButton("ResponsableTP");
    private JRadioButton radioBtn3 = new JRadioButton("Administrateur");


    //private ControlerInterface contoler=new ControlerInterface();
    private JLabel lblBackground = new JLabel();
    private JLabel logo = new JLabel(new ImageIcon("images/logo.png"));
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);

    private int identifiant = 0;

    private EtudiantControler c1;
	private ResponsableTPControler c2;
	private AdminControler c3;
	
	public SeConnecterView(/*EtudiantControler c1, ResponsableTPControler c2,
			AdminControler c3*/) {
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;	

		titre.setFont(font);
        titre.setBounds(445,20,200,40);
        jFrame.setBounds(600, 200, 1070, 550);
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

    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {
        /* Partie d'entrée - Centre */
        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(radioBtn1);
        btnGroup1.add(radioBtn3);
        btnGroup1.add(radioBtn2);

        lblBackground.setIcon(icon); // Définir l'icône à afficher par le composant d'étiquette
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);

        lbUser.setBounds(340, 130, 120, 20);
        lbPass.setBounds(340, 170, 120, 20);

        okbtn.setBounds(340,280,130,20);
        inscription.setBounds(470,280,130,20);
        cancelbtn.setBounds(600,280,120,20);
        username.setBounds(460, 130, 250, 20);
        password.setBounds(460, 170, 250, 20);
        radioBtn1.setBounds(340, 210, 115, 20);
        radioBtn2.setBounds(455, 210, 115, 20);
        radioBtn3.setBounds(605, 210, 115, 20);
        logo.setBounds(0,0,220,100);


        fieldPanel.add(lbUser);
        fieldPanel.add(lbPass);
        fieldPanel.add(titre);
        fieldPanel.add(logo);
        fieldPanel.add(okbtn);
        fieldPanel.add(cancelbtn);
        fieldPanel.add(inscription);
        fieldPanel.add(username);
        fieldPanel.add(password);
        fieldPanel.add(radioBtn1);
        fieldPanel.add(radioBtn2);
        fieldPanel.add(radioBtn3);
        radioBtn1.setSelected(true);
        fieldPanel.add(lblBackground); // Ajouter des composants au panneau

        //Définir le texte de l'étiquette en rouge
        lbIMsgI.setForeground(Color.RED);
        lbIMsgI.setBounds(500, 185, 180, 25);
        fieldPanel.add(lbIMsgI);

        c.add(fieldPanel, "Center");

        radioBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Etudient":
                        inscription.setVisible(true);
                        identifiant = 0;
                        break;

                }
            }
        });
        radioBtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {

                    case "ResponsableTP":
                        inscription.setVisible(false);
                        identifiant = 1;
                        break;

                }
            }
        });
        radioBtn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Administrateur":
                        inscription.setVisible(false);
                        identifiant = 2;
                        break;
                }
            }
        });


        okbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okbtn) {


                    String strPwd = new String(password.getPassword());
                    String strE = new String(username.getText());

                    switch (identifiant) {
                        case 0:
                            //Etudiant etudiant= new Etudiant(strE,strPwd);
                            //if (EtudiantControler.checkPasswordE(etudiant,strPwd)) {
                            jFrame.setVisible(false);
                            PageEtudiant pe = new PageEtudiant();//contoler.seekClient(strE)
                            pe.getjFrame().setVisible(true);
                       //}
                            /*  else {
                            lbIMsgI.setText("password is wrong");
                        }*/

                            break;
                        case 1:
                            /* if (contoler.checkPasswordI(contoler.seekIntervenant(strE), strPwd)) {*/
                            jFrame.setVisible(false);
                           // RecommanderTache re = new RecommanderTache();//contoler.seekIntervenant(strE)
                           // re.getjFrame().setVisible(true);
                       /* } else {
                            lbIMsgI.setText("password is wrong");
                        }*/

                            break;
                        case 2:
                            /*if (contoler.checkPasswordC(contoler.seekClient(strE), strPwd)) {*/
                            jFrame.setVisible(false);
                           // ClientInterface pa = new ClientInterface();//contoler.seekClient(strE)
                           // pa.getjFrame().setVisible(true);
                   /*     } else {
                            lbIMsgI.setText("password is wrong");
                        }*/

                            break;
                    }

                }
            }
        });

        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                username.setText("");
                password.setText("");


            }
        });

        inscription.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == inscription) {
                    switch (identifiant) {
                        case 0:
                            jFrame.setVisible(false);
                            Inscription ins = new Inscription();
                            ins.getjFrame().setVisible(true);
                            break;
                        case 1:

                            break;
                        case 2:


                            break;
                    }
                }
            }
        });


    }
}


