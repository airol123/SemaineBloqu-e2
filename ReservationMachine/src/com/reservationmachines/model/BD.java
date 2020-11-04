package com.reservationmachines.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class BD {

    static final String DB_URL = "jdbc:mysql://localhost:3306/reservationmachine?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    static Connection con;
    //static Statement sql;   //pour SELECT
    static PreparedStatement sql;  //pour UPDATE
    static ResultSet res;

    public static Connection getConnection(){
        try {
            // bd driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Succès driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("pb: Class.forName");
        }

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Succès Connexion");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("pb:JDBC ");
        }
        return con;
    }
    //Pour tester 
    
    public Etudiant seConnecter(String ide) throws SQLException {
		Etudiant etu=null;
		String sqletudiant = "select * from etudiant where ide=? and etate='valide'";
        Connection con =BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sqletudiant);
		pstmt.setInt(1, Integer. parseInt(ide));
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			etu = new Etudiant();
			System.out.println("Il y a cet etudiant");
			etu.setNom(rs.getString("nome"));	
			etu.setPrenom(rs.getString("prenome"));
			etu.setEmail(rs.getString("emaile"));
			etu.setIdentifiant(ide);
			etu.setMdp(rs.getString("mdpe"));
		}
		else {
			System.out.println("Il y a pas de cet etudiant ou en attente");
		}
		rs.close();  		
		return etu;
	}/*
    public Admin seConnecterAdmin(String ida) throws SQLException {
		Admin admin=null;
		String sqladmin = "select * from admin where ida=?";
        Connection con =BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sqladmin);
		pstmt.setInt(1, Integer. parseInt(ida));
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			admin = new Admin();
			System.out.println("Il y a cet admin");
			admin.setNom(rs.getString("noma"));	
			admin.setPrenom(rs.getString("prenoma"));
			admin.setEmail(rs.getString("emaila"));
			admin.setIdentifiant(ida);
			admin.setMdp(rs.getString("mdpa"));
		}
		else {
			System.out.println("Il y a pas de cet etudiant");
		}
		rs.close();  
		
		return admin;
	}
    */
    
	public ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle) throws SQLException {
		ArrayList<ReservationMachine> reservations = new ArrayList<ReservationMachine>();		
		String sqlreservationm = "select * from salle,machine,reserverm,etudiant where noms=? and salle.IDS=machine.IDS and machine.IDM=reserverm.IDM and reserverm.IDE=etudiant.IDE "; 
		Connection con =BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sqlreservationm);
		pstmt.setString(1, idSalle);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Etudiant etu=new Etudiant();
			etu.setNom(rs.getString("nome"));	
			etu.setPrenom(rs.getString("prenome"));
			etu.setEmail(rs.getString("emaile"));
			etu.setIdentifiant(String.valueOf(rs.getInt("ide")));
			etu.setMdp(rs.getString("mdpe"));
			Machine mac=new Machine(rs.getString("nomm"),EtatMachine.valueOf(rs.getString("etatm")));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");	
			
			String sdd=rs.getString("datem")+" "+rs.getString("heuredebutm");
			Timestamp d = null;
			try {
				d = new Timestamp(dateFormat.parse(sdd).getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			String sdf=rs.getString("datem")+" "+rs.getString("heurefinm");
			Timestamp f = null;
			try {
				f = new Timestamp(dateFormat.parse(sdf).getTime());
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
			
			reservations.add(new ReservationMachine(etu, mac, d, f));
		}
		
		
		/*
		 * Remplir la liste avec toutes les réservations de la salle 'idSalle' en paramètre
		 */
		
		/* Ceci est un test pour l'affichage
		Etudiant e = new Etudiant("21901234", "dsmlfjdf", "DUPONT", "Jean", "jean.dupont@mail.fr");
		Machine m = new Machine("A12345", EtatMachine.DISPONIBLE);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");	
		
		Timestamp d = null;
		try {
			d = new Timestamp(dateFormat.parse("03/11/2020 16:45").getTime());
		} catch (ParseException e1) {}
		Timestamp f = null;
		try {
			f = new Timestamp(dateFormat.parse("03/11/2020 18:30").getTime());
		} catch (ParseException e1) {}
		reservations.add(new ReservationMachine(e, m, d, f));
		*/
		
		return reservations;
	}
    public static void main(String[] args) throws SQLException {
        BD c= new BD();
        con = c.getConnection(); 
        ArrayList<ReservationMachine> reservations=c.getValeursReservationMachine("ME405");
        System.out.println(reservations.get(1).getNomEtudiant());
        System.out.println(reservations.get(1).getNomMachine());
        System.out.println(reservations.get(1).getEtatMachine());
        //System.out.println(reservations.get(1).getHeureDebut());
        //System.out.println(reservations.get(1).getHeureFin());
        //Pour tester
        //Etudiant e=c.seConnecter(Integer.toString(21809061));  
        //System.out.println(e.getEmail());
        //Admin a=c.seConnecterAdmin(Integer.toString(1001));  
        //System.out.println(a.getEmail());
    }
    }



