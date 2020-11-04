package com.reservationmachines.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Model extends AbstractModel {

	@Override
	public String[] getEnteteReservationMachine() {
		return new String[] {"Machine", "√©tat de la machine", "Nom √©tudiant", "Pr√©nom √©tudiant"};
	}
	
	@Override
	public ArrayList<ReservationMachine> getValeursReservationMachine(String idSalle) {
		ArrayList<ReservationMachine> reservations = new ArrayList<ReservationMachine>();
		
		/*
		 * Remplir la liste avec toutes les r√©servations de la salle 'idSalle' en param√®tre
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
	

	// ajouter une nouvelle machine et l‚Äôaffecter √† une salle
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
	public String[] getListeNomSalle() throws SQLException {
		ArrayList<String> listeNomSalle = new ArrayList<>();
		String sqlnomSalle= "select noms from salle";
        Connection con =BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sqlnomSalle);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			listeNomSalle.add(rs.getString("noms"));
		}
		rs.close();  
		
		return listeNomSalle.toArray(new String[0]);
	}

	@Override
	public boolean verifierMotDePasseEtudiant(String numEtudiant, String mdp) {
		String querySQL = "SELECT idE FROM Etudiant " +
				"WHERE idE = '" + numEtudiant + "' AND mdpE = '" + mdp + "';";

		// VÈrifier si la valeur existe dans la table
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
		String querySQL = "SELECT idResp FROM RespP " +
				"WHERE idResp = '" + idResponsableTP + "' AND mdpR = '" + mdp + "';";

		// VÈrifier si la valeur existe dans la table
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

		// VÈrifier si la valeur existe dans la table
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
	public String getPrenomEtudiant(String numEtudiant) {
		String querySQL = "SELECT nomE FROM Etudiant WHERE idE = '" + numEtudiant + "';";

		// VÈrifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			return resultat.getString(1);
		} catch (Exception e) {
			return "";
		}
	}

	@Override
	public boolean inscrireEtudiant(Etudiant etudiant) {
		return false;
	}

	/*
	@Override
	public String getPrenomResponsableTP(String idResponsableTP) {
		String querySQL = "SELECT nomA FROM RespP WHERE idResp = '" + idResponsableTP + "';";

		// VÈrifier si la valeur existe dans la table
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

		// VÈrifier si la valeur existe dans la table
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
