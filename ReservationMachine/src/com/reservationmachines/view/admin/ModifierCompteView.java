package com.reservationmachines.view.admin;

import com.reservationmachines.controler.AdminControler;
import com.reservationmachines.controler.EtudiantControler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ModifierCompteView {
    private JFrame jFrame = new JFrame("ModifierCompte");
    private EtudiantControler ec;
    private Container c = jFrame.getContentPane();
    //composition
    private JLabel titre = new JLabel("Modifier Compte");
    private JLabel lbIMsgC = new JLabel();


    private JLabel lbemail = new JLabel("E-mail");
    private JTextField txtemail = new JTextField();
    private JLabel lblPwdC = new JLabel("Mot de passe");
    private JLabel lbRePwdC = new JLabel("Vérifier MDP");

    private JLabel lbNom = new JLabel("Nom");
    private JLabel lbIdenti = new JLabel("Identifiant");
    private JLabel lbPrenom = new JLabel("Prenom");
    private JPasswordField txtPwdC = new JPasswordField();
    private JPasswordField txtRePwdC = new JPasswordField();
    private JTextField txtIdentif = new JTextField();

    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JButton okbtn = new JButton("Valider");
    private JButton resetlbtn = new JButton("réinitialiser");
    private JButton btnreturn = new JButton("Annuler");

    // background && font
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("ReservationMachine/images/background2.jpg");
    private ImageIcon icon = new ImageIcon("ReservationMachine/images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);

    private AdminControler controler;

    public ModifierCompteView(AdminControler controler) {//

        this.controler=controler;
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
        //Définir le texte de l'étiquette en rouge

        lbIMsgC.setForeground(Color.RED);
        lbIMsgC.setBounds(450, 85, 200, 25);

        lbNom.setBounds(340,150,100,30);
        lbIdenti.setBounds(340,110,100,30);
        txtNom.setBounds(450,150,220,30);
        txtIdentif.setBounds(450,110,220,30);

        lbPrenom.setBounds(340,190,100,30);
        txtPrenom.setBounds(450,190,220,30);
        lbemail.setBounds(340,230,100,30);
        txtemail.setBounds(450,230,220,30);
        lblPwdC.setBounds(340,270,100,30);
        txtPwdC.setBounds(450,270,220,30);
        lbRePwdC.setBounds(340,310,100,30);
        txtRePwdC.setBounds(450,310,220,30);

        okbtn.setBounds(340,360,110,30);
        resetlbtn.setBounds(450,360,110,30);
        btnreturn.setBounds(560,360,110,30);

        fieldPanel.add(titre);
        fieldPanel.add(lbIMsgC);

        fieldPanel.add(lbemail);
        fieldPanel.add(lbIdenti);
        fieldPanel.add(txtIdentif);
        fieldPanel.add(lblPwdC);
        fieldPanel.add(lbRePwdC);

        fieldPanel.add(lbNom);
        fieldPanel.add(lbPrenom);
        fieldPanel.add(txtemail);
        fieldPanel.add(txtPwdC);
        fieldPanel.add(txtRePwdC);
        fieldPanel.add(txtNom);
        fieldPanel.add(txtPrenom);
        fieldPanel.add(okbtn);
        fieldPanel.add(resetlbtn);
        fieldPanel.add(btnreturn);

        fieldPanel.add(lblBackground);




        c.add(fieldPanel, "Center");

        //----------------------------listener--------------------------------
        resetlbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                txtemail.setText("");
                txtPwdC.setText("");
                txtRePwdC.setText("");
                txtPrenom.setText("");
                txtNom.setText("");
                txtIdentif.setText("");


            }
        });
        btnreturn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new ConsulterCompte(controler);
            }
        });

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Définissez l'étiquette d'information pour qu'elle soit vide, effacez les informations historiques d'origine
                lbIMsgC.setText("");

                //Obtenez les informations d'utilisateur saisi par l'utilisateur

                String stremail = txtemail.getText();
                if (stremail == null || stremail.equals("")) {
                    lbIMsgC.setText("email is empty");
                    return;
                }

                String strNom = txtNom.getText();
                if (strNom == null || strNom.equals("")) {
                    lbIMsgC.setText("Nom is empty");
                    return;
                }

                String strPrenom = txtPrenom.getText();
                if (strPrenom == null || strPrenom.equals("")) {
                    lbIMsgC.setText("Prenom is empty");
                    return;
                }

                String strIdenti = new String(txtIdentif.getText());
                if (strIdenti == null || strIdenti.equals("")) {

                    lbIMsgC.setText("Identifiant is empty");
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

                if (controler.misAjourInBD(strIdenti,strNom,strPrenom ,stremail, strRePwd)){
                    lbIMsgC.setText("Successful");
                }else{
                    lbIMsgC.setText("échec");
                }




            }
        });

    }

    public JFrame getjFrame() {
        return jFrame;
    }
}

