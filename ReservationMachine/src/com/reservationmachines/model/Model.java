package com.reservationmachines.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;

public class Model extends AbstractModel {

	@Override
	public String[] getEnteteReservationMachine() {
		return new String[] {"Machine", "état de la machine", "Nom étudiant", "Prénom étudiant"};
	}

	@Override
	public ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle) {
		ArrayList<ReservationMachine> reservations = new ArrayList<ReservationMachine>();
		String sqlreservationm = "select * from salle,machine,reserverm,etudiant where noms=? and salle.IDS=machine.IDS and machine.IDM=reserverm.IDM and reserverm.IDE=etudiant.IDE ";
		try{
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
				Salle salle =new Salle();
				salle.setNomSalle(idSalle);
				Machine mac=new Machine(rs.getString("nomm"),EtatMachine.valueOf(rs.getString("etatm")),salle);
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
		}catch (Exception e3) {
			e3.printStackTrace();
		}

		/*
		 * Remplir la liste avec toutes les r�servations de la salle 'idSalle' en param�tre
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


	@Override
	public void creerCompteEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void creerCompteResponsableTP(ResponsableTP responsableTP) {

	}


	// ajouter une nouvelle machine et l’affecter à une salle
	@Override
	public void setMachineSalle(String nomMachine, String nomSalle){

	};


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
			System.out.println("Il y a pas de cet etudiant");
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

	@Override
	public boolean verifierMotDePasseEtudiant(String numEtudiant, String mdp) {
		String querySQL = "SELECT idE FROM Etudiant " +
				"WHERE idE = '" + numEtudiant + "' AND mdpE = '" + mdp + "';";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			return resultat.getString(1).equals(numEtudiant);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean verifierMotDePasseResponsableTP(String idResponsableTP, String mdp) {
		String querySQL = "SELECT idResp FROM RespTP " +
				"WHERE idResp = '" + idResponsableTP + "' AND mdpR = '" + mdp + "';";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			return resultat.getString(1).equals(idResponsableTP);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean verifierMotDePasseAdmin(String idAdmin, String mdp) {
		String querySQL = "SELECT idA FROM Admin " +
				"WHERE idA = '" + idAdmin + "' AND mdpA = '" + mdp + "';";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			return resultat.getString(1).equals(idAdmin);
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Etudiant getEtudiant(String numEtudiant) {
		String querySQL = "SELECT * FROM Etudiant WHERE idE = '" + numEtudiant + "';";
		Etudiant etudiant = null;
		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			
			etudiant = new Etudiant(
				resultat.getString("ide"),
				resultat.getString("mdpe"),
				resultat.getString("nome"),
				resultat.getString("prenome"),
				resultat.getString("emaile")
			);
			
			System.out.println("Je suis l� !");
		} catch (Exception e) {e.printStackTrace();}
		
		return etudiant;
	}

	@Override
	public boolean inscrireEtudiant(Etudiant etudiant) {
		return false;
	}

	@Override
	public ArrayList<String> recupererNomsFormations() {
		String querySQL = "SELECT NomF FROM Formation;";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);

			ArrayList<String> formations = new ArrayList<String>();
			while(resultat.next()) {
				formations.add(resultat.getString(1));
			}
			return formations;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<GroupeTP> recupererNomsGroupesTP(String nomFormation) {
		String querySQL = "SELECT NomG FROM Groupe G, Formation F " +
				"WHERE F.IdF = G.IdF " +
				"AND F.NomF = '" + nomFormation + "';";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);

			ArrayList<GroupeTP> groupesTP = new ArrayList<GroupeTP>();
			while(resultat.next()) {
				groupesTP.add(new GroupeTP(resultat.getString(1)));
			}

			return groupesTP;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean misAjourInBD(String stremail, String strRePwd) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	@Override
	public String getPrenomResponsableTP(String idResponsableTP) {
		String querySQL = "SELECT nomA FROM RespP WHERE idResp = '" + idResponsableTP + "';";
		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			return resultat.getString(1);
		} catch (SQLException e) {
			return "";
		}
	}
	@Override
	public String getPrenomAdmin(String idAdmin) {
		String querySQL = "SELECT nomR FROM Admin WHERE idA = '" + idAdmin + "';";
		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			return resultat.getString(1);
		} catch (SQLException e) {
			return "";
		}
	}

	*/
}