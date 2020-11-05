package com.reservationmachines.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Model extends AbstractModel {

	protected final static String HEURE_RESERVATION_SEPARATEUR = ":";
	protected final static String HEURE_RESERVATION_SALLE_MIN = "08:00";
	protected final static String HEURE_RESERVATION_SALLE_MAX = "20:00";
	protected final static String FREQUENCE_RESERVATION_EN_HEURE = "01:30";
	
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

	@Override
	public String[] getReservationsSallesDates() {
		// Initialisation � la date d'aujourd'hui
        LocalDate day = LocalDate.now();
        // Ex. mer. 04/11/2020
        DateTimeFormatter date = DateTimeFormatter.ofPattern("EEE dd/MM/yyyy");
        // Le num�ro du jour de la semaine (ex. 3 pour mercredi)
        DateTimeFormatter dayName = DateTimeFormatter.ofPattern("e");
        String[] result = new String[100];
        
        for(int i = 0 ; i < result.length ; i++) {
        	// Si c'est samedi, on avance deux de jours
        	if(Integer.parseInt(day.format(dayName)) == 6)
        		day = day.plusDays(2);
        	// Si c'est dimanche, on avance de 1 jour
        	if(Integer.parseInt(day.format(dayName)) == 7)
        		day = day.plusDays(1);
        	
        	result[i] = day.format(date);   
        	
        	// Jour suivant
        	day = day.plusDays(1);
        }
        
        return result;
	}

	@Override
	public ArrayList<Salle> getValeursSallesDisponibles(String date, String heureDebut, String heureFin) {
		String querySQL = "SELECT NomS, COUNT(M.IdM) AS Capacite\r\n" + 
				"FROM Salle S, Machine M\r\n" + 
				"WHERE S.IdS = M.IdS \r\n" + 
				"	AND NOT EXISTS (\r\n" + 
				"		SELECT *    \r\n" + 
				"		FROM ReserverS RS1\r\n" + 
				"        WHERE RS1.IdS = S.IdS\r\n" + 
				"        AND NOT EXISTS (\r\n" + 
				"			SELECT *       \r\n" + 
				"			FROM ReserverS RS2\r\n" + 
				"			WHERE (UNIX_TIMESTAMP(RS2.HeureDebuts) > UNIX_TIMESTAMP(CAST('09:30' AS TIME))   \r\n" + 
				"				OR UNIX_TIMESTAMP(RS2.HeureFins) < UNIX_TIMESTAMP(CAST('08:00' AS TIME)))     \r\n" + 
				"				AND UNIX_TIMESTAMP(RS2.Dates) = UNIX_TIMESTAMP(CAST('2020-11-05' AS DATE))\r\n" + 
				"				AND RS1.Ids = RS2.IdS\r\n" + 
				"		)\r\n" + 
				"	)\r\n" + 
				"GROUP BY NomS, S.IdS;\r\n" + 
				";";
		
		System.out.println(querySQL);

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			
			ArrayList<Salle> salles = new ArrayList<Salle>();
			while(resultat.next()) {
				salles.add(new Salle(resultat.getString("NomS"), resultat.getInt("Capacite")));
			}
			
			return salles;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String[] getEnteteSallesDisponibles() {
		return new String[] {"Salle", "Capacité"};
	}

	@Override
	public String[] getReservationsSallesHeuresDebuts(String heureFin) {
		ArrayList<String> heuresDebuts = new ArrayList<String>();
		int hDebut = Integer.parseInt(HEURE_RESERVATION_SALLE_MIN.split(HEURE_RESERVATION_SEPARATEUR)[0]);
		int mDebut = Integer.parseInt(HEURE_RESERVATION_SALLE_MIN.split(HEURE_RESERVATION_SEPARATEUR)[1]);
		int hFin = Integer.parseInt(heureFin.split(HEURE_RESERVATION_SEPARATEUR)[0]);
		int mFin = Integer.parseInt(heureFin.split(HEURE_RESERVATION_SEPARATEUR)[1]);
		int hFrequence = Integer.parseInt(FREQUENCE_RESERVATION_EN_HEURE.split(HEURE_RESERVATION_SEPARATEUR)[0]);
		int mFrequence = Integer.parseInt(FREQUENCE_RESERVATION_EN_HEURE.split(HEURE_RESERVATION_SEPARATEUR)[1]);
		
		do {
			if(mDebut >= 60) {
				mDebut = mDebut % 60;
				hDebut++;
			}
			
			String tmp = "";
			// Si les heures sont inf�rieures � 10, alors on ajoute un z�ro
			tmp += (hDebut < 10) ? "0" + hDebut : "" + hDebut;
			tmp += HEURE_RESERVATION_SEPARATEUR;
			// Si les minutes sont inf�rieures � 10, alors on ajoute un z�ro
			tmp += (mDebut < 10) ? "0" + mDebut : "" + mDebut;
			
			heuresDebuts.add(tmp);
			
			hDebut = (hDebut + hFrequence) % 24;
			mDebut = (mDebut + mFrequence);			
		} while(hDebut % 24 < hFin - hFrequence || mDebut % 60 < mFin - mFrequence);
		
		String[] result = new String[heuresDebuts.size()];
		for(int i = 0 ; i < heuresDebuts.size() ; i++) result[i] = heuresDebuts.get(i);
		
		return result;
	}

	@Override
	public String[] getReservationsSallesHeuresFins(String heureDebut) {
		ArrayList<String> heuresDebuts = new ArrayList<String>();
		int hDebut = Integer.parseInt(heureDebut.split(HEURE_RESERVATION_SEPARATEUR)[0]);
		int mDebut = Integer.parseInt(heureDebut.split(HEURE_RESERVATION_SEPARATEUR)[1]);
		int hFin = Integer.parseInt(HEURE_RESERVATION_SALLE_MAX.split(HEURE_RESERVATION_SEPARATEUR)[0]);
		int mFin = Integer.parseInt(HEURE_RESERVATION_SALLE_MAX.split(HEURE_RESERVATION_SEPARATEUR)[1]);
		int hFrequence = Integer.parseInt(FREQUENCE_RESERVATION_EN_HEURE.split(HEURE_RESERVATION_SEPARATEUR)[0]);
		int mFrequence = Integer.parseInt(FREQUENCE_RESERVATION_EN_HEURE.split(HEURE_RESERVATION_SEPARATEUR)[1]);
		
		hDebut += hFrequence;
		mDebut += mFrequence;
		
		do {
			if(mDebut >= 60) {
				mDebut = mDebut % 60;
				hDebut++;
			}
			
			String tmp = "";
			// Si les heures sont inf�rieures � 10, alors on ajoute un z�ro
			tmp += (hDebut < 10) ? "0" + hDebut : "" + hDebut;
			tmp += HEURE_RESERVATION_SEPARATEUR;
			// Si les minutes sont inf�rieures � 10, alors on ajoute un z�ro
			tmp += (mDebut < 10) ? "0" + mDebut : "" + mDebut;
			
			heuresDebuts.add(tmp);
			
			hDebut = (hDebut + hFrequence) % 24;
			mDebut = (mDebut + mFrequence);			
		} while(hDebut % 24 < hFin || mDebut % 60 <= mFin);
		
		String[] result = new String[heuresDebuts.size()];
		for(int i = 0 ; i < heuresDebuts.size() ; i++) result[i] = heuresDebuts.get(i);
		
		return result;
	}

	@Override
	public String[] getReservationsSallesHeuresDebuts() {
		return getReservationsSallesHeuresDebuts(HEURE_RESERVATION_SALLE_MAX);
	}

	@Override
	public String[] getReservationsSallesHeuresFins() {
		return getReservationsSallesHeuresFins(HEURE_RESERVATION_SALLE_MIN);
	}

	@Override
	public void reserverSalle(ReservationSalle reservationSalle) {
		String querySQL = "SELECT IdS FROM Salle WHERE NomS LIKE '" + reservationSalle.getNomSalle() + "';";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(querySQL);
			result.next();
			
			querySQL = "INSERT INTO ReserverS (" 
				+ reservationSalle.getHeureDebut() + ", " 
				+ reservationSalle.getDate() + ", "
				+ reservationSalle.getResponsableTP().identifiant + ", "
				+ result.getString("IdS") + ", "
				+ reservationSalle.getHeureFin() + ", "
				+ reservationSalle.getNomCours() + ", "
			+ ");";

			statement.executeUpdate(querySQL);
		} catch (Exception e) {}
	}

	@Override
	public String[] recupererNomTP(String id) {
		String querySQL = "SELECT DISTINCT NomTP FROM ReserverS WHERE IdResp = '" + id + "';";

		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			
			ArrayList<String> nomsTP = new ArrayList<String>();
			while(resultat.next()) {
				nomsTP.add(resultat.getString(1));
			}

			String[] result = new String[nomsTP.size()];
			for(int i = 0 ; i < nomsTP.size() ; i++) result[i] = nomsTP.get(i);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<ReservationSalle> getValeursReservees(String id) {
		String querySQL = "SELECT NomTP, NomF, NomG, Dates, HeureDebuts, HeureFins, NomS, COUNT(DISTINCT M.IdM) Capacite\n";
		querySQL += "FROM ReserverS RS, Salle S, Groupe G, Formation F, Machine M\n";
		querySQL += "WHERE S.IdS = RS.IdS\n";
		querySQL += "	AND M.IdS = S.IdS\n";
		querySQL += "	AND G.IdF = F.IdF\n";
		querySQL += "	AND G.IdG = RS.IdG\n";
		querySQL += "	AND RS.IdResp = '" + id + "'\n";
		querySQL += "GROUP BY NomTP, NomF, NomG, Dates, HeureDebuts, HeureFins, NomS;";
		
		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			
			ArrayList<ReservationSalle> reservationsSalles = new ArrayList<ReservationSalle>();
			
			while(resultat.next()) {			
				String nomCours = resultat.getString("NomTP");
				ResponsableTP responsableTP = new ResponsableTP(id);
				Salle salle = new Salle(resultat.getString("NomS"), resultat.getInt("Capacite"));
				GroupeTP groupeTP = new GroupeTP(resultat.getString("NomG"));
				String formation = resultat.getString("NomF");
				Date date = resultat.getDate("Dates");
				Timestamp heureDebut = resultat.getTimestamp("HeureDebuts");
				Timestamp heureFin = resultat.getTimestamp("HeureFins");
				
				ReservationSalle reservation = new ReservationSalle(nomCours, responsableTP, salle, groupeTP, formation, date, heureDebut, heureFin);
				
				reservationsSalles.add(reservation);
			}
			
			return reservationsSalles;
		} catch (Exception e) {e.printStackTrace();}
		
		return null;
	}

	@Override
	public String[] getEnteteSallesReservees() {
		return new String[] {"Cours", "Formation", "Groupe de TP", "Date", "Heure début", "Heure Fin", "Nom de la salle", "Capacite", "Réservations machines", "Annuler une réservation"};
	}

	@Override
	public String getPrenomResponsableTP(String idResponsableTP) {
		String querySQL = "SELECT PrenomR FROM RespTP WHERE IdResp = '" + idResponsableTP + "';";

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

	// Retirer la réservation de la salle "idSalle" (NomS)
	@Override
	public void annulerReservationSalle(String idSalle) {
		// TODO Auto-generated method stub
		
	}

	// Retirer toutes les réservations machine pour la salle "idSalle" (NomS)
	@Override
	public void annulerToutesReservationsMachinesSalle(String idSalle) {
		
	}
	
	/*
	@Override
	public String getPrenomAdmin(String idAdmin) {
		String querySQL = "SELECT PrenomA FROM Admin WHERE IdA = '" + idAdmin + "';";

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
