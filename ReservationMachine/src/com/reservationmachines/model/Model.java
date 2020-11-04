package com.reservationmachines.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class Model extends AbstractModel {

	@Override
	public String[] getEnteteReservationMachine() {
		return new String[] {"Machine", "État de la machine", "Nom étudiant", "Prénom �tudiant"};
	}
	
	@Override
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
	}
	
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
	
	public ResponsableTP seConnecterResponsable(String idres) throws SQLException {
		ResponsableTP restp=null;
		String sqlresp= "select * from resptp where idresp=?";
        Connection con =BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sqlresp);
		pstmt.setInt(1, Integer. parseInt(idres));
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			restp = new ResponsableTP();
			System.out.println("Il y a cet admin");
			restp.setNom(rs.getString("noma"));	
			restp.setPrenom(rs.getString("prenoma"));
			restp.setEmail(rs.getString("emaila"));
			restp.setIdentifiant(idres);
			restp.setMdp(rs.getString("mdpa"));
		}
		else {
			System.out.println("Il y a pas de cet etudiant");
		}
		rs.close();  
		
		return restp;
	}


}
