package com.reservationmachines.view.etudiant;

import com.reservationmachines.controler.EtudiantControler;
import com.reservationmachines.main.AppMain;
import com.reservationmachines.model.Etudiant;
import com.reservationmachines.view.main.SeConnecterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Inscription {
    private JFrame jFrame = new JFrame("Inscription");
    private EtudiantControler ec;
    private Container c = jFrame.getContentPane();
    //composition
    private JLabel titre = new JLabel("Inscription");
    private JLabel lbIMsgC = new JLabel();

    private JLabel lbIdent = new JLabel("Indentifiant");
    private JTextField txtidentifiant = new JTextField();
    private JLabel lbnom = new JLabel("Nom");
    private JTextField txtnom = new JTextField();
    private JLabel lbprenom = new JLabel("Prenom");
    private JTextField txtprenom = new JTextField();
    private JLabel lbemail = new JLabel("E-mail");
    private JTextField txtemail = new JTextField();
    private JLabel lblPwdC = new JLabel("Mot de passe");
    private JLabel lbRePwdC = new JLabel("Vérifier MDP");
    private JPasswordField txtPwdC = new JPasswordField();
    private JPasswordField txtRePwdC = new JPasswordField();
    private JButton okbtn = new JButton("Valider");
    private JButton resetlbtn = new JButton("réinitialiser");
    private JButton btnreturn = new JButton("Annuler");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);

    private EtudiantControler controler;
    
    public Inscription(EtudiantControler controler) {
    	this.controler = controler;
    	
        titre.setFont(font);
        titre.setBounds(435,20,200,40);
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
        //Définir le texte de l'étiquette en rouge

        lbIMsgC.setForeground(Color.RED);
        lbIMsgC.setBounds(450, 370, 200, 25);
        lbIdent.setBounds(340,130,100,30);
        txtidentifiant.setBounds(450,130,220,30);
        lbnom.setBounds(340,170,100,30);
        txtnom.setBounds(450,170,220,30);
        lbprenom.setBounds(340,210,100,30);
        txtprenom.setBounds(450,210,220,30);
        lbemail.setBounds(340,250,100,30);
        txtemail.setBounds(450,250,220,30);
        lblPwdC.setBounds(340,290,100,30);
        txtPwdC.setBounds(450,290,220,30);
        lbRePwdC.setBounds(340,330,100,30);
        txtRePwdC.setBounds(450,330,220,30);

        okbtn.setBounds(340,400,110,30);
        resetlbtn.setBounds(450,400,110,30);
        btnreturn.setBounds(560,400,110,30);

        fieldPanel.add(titre);
        fieldPanel.add(lbIMsgC);
        fieldPanel.add(lbIdent);
        fieldPanel.add(lbnom);
        fieldPanel.add(lbprenom);
        fieldPanel.add(lbemail);
        fieldPanel.add(lblPwdC);
        fieldPanel.add(lbRePwdC);
        fieldPanel.add(txtidentifiant);
        fieldPanel.add(txtnom);
        fieldPanel.add(txtprenom);
        fieldPanel.add(txtemail);
        fieldPanel.add(txtPwdC);
        fieldPanel.add(txtRePwdC);
        fieldPanel.add(okbtn);
        fieldPanel.add(resetlbtn);
        fieldPanel.add(btnreturn);

        fieldPanel.add(lblBackground);




        c.add(fieldPanel, "Center");

        //----------------------------listener--------------------------------
        resetlbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                txtidentifiant.setText("");
                txtemail.setText("");
                txtnom.setText("");
                txtprenom.setText("");
                txtPwdC.setText("");
                txtRePwdC.setText("");


            }
        });
        btnreturn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new AppMain();
            }
        });

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Définissez l'étiquette d'information pour qu'elle soit vide, effacez les informations historiques d'origine
                lbIMsgC.setText("");

                //Obtenez le nom d'utilisateur saisi par l'utilisateur
                String strNom = txtnom.getText();
                if (strNom == null || strNom.equals("")) {
                    lbIMsgC.setText("nom is empty");
                    return;
                }
                String strprenom = txtprenom.getText();
                if (strprenom == null || strprenom.equals("")) {
                    lbIMsgC.setText("prenom is empty");
                    return;
                }
                String stremail = txtemail.getText();
                if (stremail == null || stremail.equals("")) {
                    lbIMsgC.setText("email is empty");
                    return;
                }
                String strident = txtidentifiant.getText();
                if (strident == null || strident.equals("")) {
                    lbIMsgC.setText("identifiant is empty");
                    return;
                }
                //Obtenez un nom d'utilisateur et un mot de passe
                String strPwd = new String(txtPwdC.getPassword());
                if (strPwd == null || strPwd.equals("")) {

                    lbIMsgC.setText("password is empty");
                    return;
                }
                String strRePwd = new String(txtRePwdC.getPassword());
                if (strRePwd == null || strRePwd.equals("")) {

                    lbIMsgC.setText("password is empty");
                    return;
                }

                //Déterminez si le mot de passe de confirmation est le même que le mot de passe
                if (!strRePwd.equals(strPwd)) {

                    lbIMsgC.setText("password is false");
                    return;
                }

                controler.inscrireEtudiant(strident, strPwd, strNom, strprenom, stremail);
                
                lbIMsgC.setText("Successful");

            }
        });

    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
