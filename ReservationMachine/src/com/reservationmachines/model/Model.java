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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

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
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
				
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
	
	//Trouver une etudiant selon son identifiant
	@Override
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
	
	@Override
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
	
	@Override
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
	public String[] getListeNomSalle() {
		ArrayList<String> listeNomSalle = new ArrayList<>();
		String sqlnomSalle= "select noms from salle";
        Connection con =BD.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sqlnomSalle);
			
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				listeNomSalle.add(rs.getString("noms"));
			}
			rs.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeNomSalle.toArray(new String[0]);
	}

	@Override
	public boolean verifierMotDePasseEtudiant(String numEtudiant, String mdp) {
		String querySQL = "SELECT idE FROM Etudiant " +
		"WHERE idE = '" + numEtudiant + "' AND mdpE = '" + mdp + "' AND EtatE='valide';";

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
		int n=0;
		String sqlinsertetu="INSERT INTO etudiant (ide,mdpe, emaile,nome, prenome, etate) VALUES (?,?,?,?,?,'attente');";
		try {
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlinsertetu);

			pstmt.setInt(1,Integer.parseInt(etudiant.getIdentifiant()));
			pstmt.setString(2, etudiant.mdp);
			pstmt.setString(3, etudiant.email);
			pstmt.setString(4, etudiant.nom);
			pstmt.setString(5, etudiant.prenom);
			n=pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		if (n==1) {
			return true;
		}
		else {
			return false;
		}
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
	public boolean misAjourInBD(String stremail, String strRePwd, String id) {
		String sql = "update etudiant set emaile=?,mdpe=? where ide = ?";			
		int nbe=0;
		try {
			Connection con = BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stremail);
			pstmt.setString(2, strRePwd);
			pstmt.setInt(3, Integer.parseInt(id));
			nbe=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(nbe==0) {
			return false;
		}
		else {
			return true;
		}
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
	public ArrayList<ReservationMachine> getReservationMachineE(String etudiant) {
		ArrayList<ReservationMachine> reservations = new ArrayList<ReservationMachine>();
		String sqlreservationm = "select * from salle,machine,reserverm,etudiant where etudiant.IDE=? and salle.IDS=machine.IDS and machine.IDM=reserverm.IDM and reserverm.IDE=etudiant.IDE "; 
		try{
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlreservationm);
			pstmt.setInt(1, Integer.parseInt(etudiant));
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Etudiant etu=new Etudiant();
				etu.setNom(rs.getString("nome"));
				etu.setPrenom(rs.getString("prenome"));
				etu.setEmail(rs.getString("emaile"));
				etu.setIdentifiant(etudiant);
				etu.setMdp(rs.getString("mdpe"));
				Salle salle =new Salle();
				salle.setNomSalle(rs.getString("noms"));
				Machine mac=new Machine(rs.getString("nomm"),EtatMachine.valueOf(rs.getString("etatm")),salle);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
	public ArrayList<Salle> getToutesLesSalles() {
		ArrayList<Salle> salles = new ArrayList<Salle>();
		String sqlsalle = "select * from salle;"; 
		try{
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlsalle);
			ResultSet rs=pstmt.executeQuery(sqlsalle);
			while(rs.next()) {
				Salle salle =new Salle();
				salle.setNomSalle(rs.getString("noms"));					
				salles.add(salle);
			}
		}catch (Exception e3) {
			e3.printStackTrace();
		}		
		return salles;
	}

	@Override
	public Admin getAdmin(String numAdmin) {
		String querySQL = "SELECT * FROM Admin WHERE idA = '" + numAdmin + "';";
		Admin admin = null;
		// V�rifier si la valeur existe dans la table
		try {
			Connection connection = BD.getConnection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultat = statement.executeQuery(querySQL);
			resultat.next();
			
			admin = new Admin(
				resultat.getString("ida"),
				resultat.getString("mdpa"),
				resultat.getString("noma"),
				resultat.getString("prenoma"),
				resultat.getString("emaila")
			);
			
		} catch (Exception e) {e.printStackTrace();}
		
		return admin;
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
				Date date = resultat.getDate("Dates", Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris")));
				Timestamp heureDebut = resultat.getTimestamp("HeureDebuts", Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris")));
				Timestamp heureFin = resultat.getTimestamp("HeureFins", Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris")));
				
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
	public boolean annulerReservationSalle(ReservationSalle reservationSalle) {
		String querySQL = 
			"DELETE FROM ReserverS\r\n" + 
			"WHERE UNIX_TIMESTAMP(HeureDebuts) = UNIX_TIMESTAMP(CAST(? AS TIME))\r\n" + 
			"	AND UNIX_TIMESTAMP(Dates) = UNIX_TIMESTAMP(CAST(? AS DATE))\r\n" + 
			"    AND IdResp = ?\r\n" + 
			"    AND IdS = ?\r\n" + 
			"    AND IdG = ?\r\n" + 
			";";
		
		try {
			String idResp = reservationSalle.getResponsableTP().identifiant;
			int idS = chercherIdSalle(reservationSalle.getSalle());
			int idG = chercherIdGroupeTP(reservationSalle.getGroupeTP());
			
			Connection connection = BD.getConnection();
			PreparedStatement statement = connection.prepareStatement(querySQL);
			statement.setString(1, reservationSalle.getHeureDebut());
			statement.setString(2, reservationSalle.getDate());
			statement.setString(3, idResp);
			statement.setInt(4, idS);
			statement.setInt(5, idG);
			
			return (statement.executeUpdate() == 1) ? true : false;
		} catch (SQLException e) {return false;}
	}

	private int chercherIdGroupeTP(GroupeTP groupeTP) {
		String querySQL = 
			"SELECT IdG\r\n" + 
			"FROM Groupe G, Formation F\r\n" + 
			"WHERE G.NomG LIKE ?\r\n" + 
			"	AND F.NomF LIKE ?\r\n" + 
			"    AND G.IdF = F.IdF\r\n" + 
			";";
		
		try {
			Connection connection = BD.getConnection();
			PreparedStatement statement = connection.prepareStatement(querySQL);
			statement.setString(1, groupeTP.getNomGroupe());
			statement.setString(2, groupeTP.getNomFormation());
			
			ResultSet result = statement.executeQuery();
			result.next();
			
			return result.getInt("IdG");
		} catch (SQLException e) {e.printStackTrace(); return -1;}
	}

	private int chercherIdSalle(Salle salle) {
		String querySQL = 
			"SELECT IdS\r\n" + 
			"FROM Salle\r\n" + 
			"WHERE NomS LIKE ?;";
		
		try {
			Connection connection = BD.getConnection();
			PreparedStatement statement = connection.prepareStatement(querySQL);
			statement.setString(1, salle.getNomSalle());
			
			ResultSet result = statement.executeQuery();
			result.next();
			
			return result.getInt("IdS");
		} catch (SQLException e) {return -1;}
	}

	// Retirer toutes les réservations machine pour la salle "idSalle" (NomS)
	@Override
	public boolean annulerToutesReservationsMachinesSalle(ReservationSalle reservationSalle) {
		return false;
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

	// get liste des reclamations qui sont traitees par un admin
	@Override
	public String[][] getReclamations(String identifiant) {
		String[][] strings = null;
		String sqlreservationm = "select ide,idm,typer,descriptionr from concerner,reclamation,traiter "
				+ "where traiter.ida=? and traiter.idr=reclamation.idr "
				+ "and reclamation.idr=concerner.idr "
				+ "and reclamation.etatr='EN_COURS'"; 
		try{
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlreservationm);
			pstmt.setInt(1, Integer.parseInt(identifiant));
			ResultSet rs=pstmt.executeQuery();
			rs.last();
			int nbLignes = rs.getRow();
			rs.absolute(0);
			int nbColonnes = 4;
			strings = new String[nbLignes][nbColonnes];
			int i = 0;
			while(rs.next()) {
				strings[i][0] = rs.getString("ide");
				strings[i][1] = rs.getString("idm");
				strings[i][2] = rs.getString("typer");
				strings[i][3] = rs.getString("descriptionr");
				i++;
			}
		}catch (Exception e3) {
			e3.printStackTrace();
		}
		
		return strings;
	}

	// changer l'etat d'une reclamation de 'EN_COURS' a 'TRAITEE'
	@Override
	public void traiterReclamation(String description) {
		
		String sql = "UPDATE reclamation SET ETATR = 'TRAITEE' WHERE reclamation.descriptionr=\""+description+"\""; 
		try{
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch (Exception e3) {
			e3.printStackTrace();
		}
		
	}

	@Override
	public boolean stockerReclamation(Reclamation re) {
		int n=0;
		int n2=0;
		String sqlinsertrec="INSERT INTO reclamation (idr,typer, descriptionr,etatr) VALUES (?,?,?,'EN_COURS');";
		int idr=this.trouverMaxReclamation();
		try {
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlinsertrec);
			pstmt.setInt(1,idr);
			pstmt.setString(2, String.valueOf(re.getType()));
			pstmt.setString(3, re.getDescription());
			n=pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		//System.out.println(re.getRm().getEtudiant().getIdentifiant()+"---------");
		//System.out.println(re.getRm().getNomMachine()+"+++++++");
		//System.out.println(this.trouverNumeroM(re.getRm().getNomMachine())+"////////");
		n2=this.insertConcerner(idr,re.getRm().getEtudiant().getIdentifiant(),this.trouverNumeroM(re.getRm().getNomMachine()));
		if (n2==1 && n==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private int trouverMaxReclamation() {
		String sql="SELECT max(reservationmachine.reclamation.IDR) FROM reservationmachine.reclamation";
		int nbIDR=0;
		try {
		Connection con = BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs =pstmt.executeQuery(sql);
		while (rs.next()) {
			nbIDR=rs.getInt(1);
			nbIDR=nbIDR+1;
		}
		rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return nbIDR;
	}
	
	private int insertConcerner(int idr,String ide,int idm) {
		String sql="INSERT INTO concerner (idr,ide, idm) VALUES (?,?,?);";
		int nbexe=0;
		try {
		Connection con = BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,idr);
		pstmt.setInt(2, Integer.parseInt(ide));
		pstmt.setInt(3, idm);
		nbexe=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return  nbexe;
	}
	
	private int trouverNumeroM(String nomm) {
		String sql="select * from machine where machine.NOMM='"+nomm+"';";
		int idm=0;
		try {
		Connection con = BD.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs =pstmt.executeQuery(sql);
		if(rs.next()) {
			idm=Integer.parseInt(rs.getString("machine.IDM"));
		}
		rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return idm;
	}

	@Override
	public boolean supprimerRservation(ReservationMachine reservationMachine) {
		int n=0;
		String sql ="DELETE reserverm FROM reserverm,machine where reserverm.IDM=machine.IDM and reserverm.IDE=? and machine.NOMM=? and reserverm.HEUREDEBUTM=? and reserverm.DATEM=?;"; 
		try { 
			Connection con = BD.getConnection(); 
			PreparedStatement pstmt =  con.prepareStatement(sql); 
			pstmt.setInt(1,  Integer.parseInt(reservationMachine.getEtudiant().identifiant));
			pstmt.setString(2, reservationMachine.getMachine().getNomMachine());
				
			Date reserdebut=new Date(reservationMachine.getHeureDebut().getTime());
			System.out.println(reserdebut+"----");
			SimpleDateFormat formattimed = new SimpleDateFormat("yyyy-MM-dd"); 
			SimpleDateFormat formattimeh = new SimpleDateFormat("HH:mm:ss"); 
			String heuredebut=formattimeh.format(reserdebut);
			String date=formattimed.format(reserdebut);
			
			pstmt.setString(3, heuredebut); 
			pstmt.setString(4, date); 
			n=pstmt.executeUpdate();
			
		}catch (Exception e) { e.printStackTrace(); }
		if (n==1) {
			return true;
		}
		else {
			return false;
		}
		/*
		* //java.sql.Date heuredebut = new java.sql.Date(heure); try { Date
		* dateR=formattimeh.parse(date); Date heuredebut = formattimeh.parse(heure);
		* System.out.println(heuredebut+"--test--"); } catch (ParseException e) {
		* e.printStackTrace(); } System.out.println(date+"--d--");
		* System.out.println(heure+"--h--");
		*/	
	}

	@Override
	public ArrayList<Machine> trouverMDisponible(String sallenom, String dateD, String dateF) {
		ArrayList<Machine> machines=new ArrayList<Machine>();
		dateD = dateD + ":00";
		DateTimeFormatter fommatter1 =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime1  = LocalDateTime.parse(dateD, fommatter1);//datetime: 2020-11-05T08:06
		//System.out.println("datetime: "+dateTime1);
		Timestamp timestamp1 = Timestamp.valueOf(dateTime1);//timestamp: 2020-11-05 08:06:00.0	
		//System.out.println("timestamp: "+timestamp);
		
		dateF = dateF + ":00";
		LocalDateTime dateTime2  = LocalDateTime.parse(dateF, fommatter1);//datetime: 2020-11-05T08:06
		//System.out.println("datetime: "+dateTime1);
		Timestamp timestamp2 = Timestamp.valueOf(dateTime2);//timestamp: 2020-11-05 08:06:00.0	
		//System.out.println("timestamp: "+timestamp);
		
		Date reserdebut=new Date(timestamp1.getTime());
		Date reserfin=new Date(timestamp2.getTime());
		//System.out.println(reserdebut+"----");
		SimpleDateFormat formattimed = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat formattimeh = new SimpleDateFormat("HH:mm:ss"); 
		String heuredebut=formattimeh.format(reserdebut);
		String heurefin=formattimeh.format(reserfin);
		String date=formattimed.format(reserdebut);
		//System.out.println(heuredebut+"--1--");
		//System.out.println(heurefin+"--2--");
		//System.out.println(date+"--3--");
		
		String sql="select distinct machine.IDM ,machine.NOMM,machine.ETATM \r\n" + 
				"	from salle,machine,reserverm,etudiant \r\n" + 
				"	where salle.NOMS=? \r\n" + 
				"	and salle.IDS=machine.IDS \r\n" + 
				"	and machine.IDM=reserverm.IDM \r\n" + 
				"	and reserverm.IDE=etudiant.IDE \r\n" + 
				"	and machine.ETATM<>'HORS_SERVICE'\r\n" + 
				"	and machine.IDM not in\r\n" + 
				"		(select reserverm.IDM \r\n" + 
				"		from reserverm \r\n" + 
				"		where (reserverm.datem=? and reserverm.HEUREDEBUTM > ? and reserverm.HEUREDEBUTM < ? )\r\n" + 
				"		or (reserverm.datem=? and reserverm.HEUREFINM > ? and reserverm.HEUREFINM  < ?)\r\n" + 
				"        or (reserverm.datem=? and reserverm.HEUREDEBUTM < ? and reserverm.HEUREFINM  > ?));";
		try { 
			Connection con = BD.getConnection(); 
			PreparedStatement pstmt =  con.prepareStatement(sql); 
			pstmt.setString(1,sallenom);
			pstmt.setString(2,date);
			pstmt.setString(3,heuredebut);
			pstmt.setString(4,heurefin);
			pstmt.setString(5,date);
			pstmt.setString(6,heuredebut);
			pstmt.setString(7,heurefin);
			pstmt.setString(8,date);
			pstmt.setString(9,heuredebut);
			pstmt.setString(10,heurefin);
			ResultSet rs=pstmt.executeQuery();
			Salle salle =new Salle();
			salle.setNomSalle(sallenom);
			while (rs.next()) {
				Machine mac=new Machine(rs.getString("nomm"),EtatMachine.valueOf(rs.getString("etatm")),salle);
				machines.add(mac);
			}
			rs.close();
		}catch (Exception e) { e.printStackTrace(); }
		return machines;
	}

	@Override
	public Boolean affecterReservationM(Machine machine, Etudiant etudiant, String dateD, String dateF) {
		dateD = dateD + ":00";
		DateTimeFormatter fommatter1 =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime1  = LocalDateTime.parse(dateD, fommatter1);//datetime: 2020-11-05T08:06
		//System.out.println("datetime: "+dateTime1);
		Timestamp timestamp1 = Timestamp.valueOf(dateTime1);//timestamp: 2020-11-05 08:06:00.0	
		//System.out.println("timestamp: "+timestamp);
		
		dateF = dateF + ":00";
		LocalDateTime dateTime2  = LocalDateTime.parse(dateF, fommatter1);//datetime: 2020-11-05T08:06
		//System.out.println("datetime: "+dateTime1);
		Timestamp timestamp2 = Timestamp.valueOf(dateTime2);//timestamp: 2020-11-05 08:06:00.0	
		//System.out.println("timestamp: "+timestamp);
		
		Date reserdebut=new Date(timestamp1.getTime());
		Date reserfin=new Date(timestamp2.getTime());
		//System.out.println(reserdebut+"----");
		SimpleDateFormat formattimed = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat formattimeh = new SimpleDateFormat("HH:mm:ss"); 
		String heuredebut=formattimeh.format(reserdebut);
		String heurefin=formattimeh.format(reserfin);
		String date=formattimed.format(reserdebut);
		//System.out.println(heuredebut+"--1--");
		//System.out.println(heurefin+"--2--");
		//System.out.println(date+"--3--");
		
		int n=0;
		String sqlinsertreser="INSERT INTO reserverm (ide,idm, heuredebutm , datem, heurefinm) "
				+ "VALUES ("+Integer.parseInt(etudiant.getIdentifiant())+","+this.trouverNumeroM(machine.getNomMachine())+",'"+ heuredebut+"','"+ date+"','"+ heurefin+"');";
		try {
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlinsertreser);

			n=pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		if (n==1) {
			return true;
		}
		else {
			return false;
		}	

	}


	// get tableau des salles 
	@Override
	public String[][] getSalles() {
		String[][] strings = null;
		try{
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT noms, count(m.idm) as capacite "+
					"FROM reservationmachine.salle s left outer join reservationmachine.machine m "+
					"on s.ids = m.ids "+
					"group by s.ids, s.noms;");
			ResultSet rs=pstmt.executeQuery();
			rs.last();
			int nbLignes = rs.getRow();
			rs.absolute(0);
			int nbColonnes = 2;
			strings = new String[nbLignes][nbColonnes];
			int i = 0;
			while(rs.next()) {
				strings[i][0] = rs.getString("noms");
				strings[i][1] = rs.getString("capacite");
				i++;
			}
		}catch (Exception e3) {
			e3.printStackTrace();
		}		
		return strings;
	}

	// ajouter une nouvelle salle
	@Override
	public void ajoutSalle(String nomSalle){
		try {
		Connection con =BD.getConnection();
		PreparedStatement sql = con.prepareStatement( "select max(ids) from salle;");
		ResultSet res = sql.executeQuery();
		res.next();
		int idSalle = res.getInt(1)+1;
		PreparedStatement sql1 = con.prepareStatement( "insert into salle(ids,noms) values(?,?);");
		sql1.setInt(1, idSalle);
		sql1.setString(2, nomSalle);
		sql1.executeUpdate();		
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}		
	};

	@Override
	public void supprimerSalle(String nomSalle) {
		try {
		Connection con =BD.getConnection();
		PreparedStatement sql = con.prepareStatement( "DELETE FROM salle WHERE noms=?;");
		sql.setString(1, nomSalle);
		sql.executeUpdate();		
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }	
	}

	@Override
	public boolean miseAJourcompteE(String identifiant, String nom, String prenom, String email, String rePwd) {
		String sql = "update etudiant set emaile=?,mdpe=?,nome=?, prenome=? where ide = ?";			
		int nbexe=0;
		try {
			Connection con = BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, rePwd);
			pstmt.setString(3, nom);
			pstmt.setString(4, prenom);
			pstmt.setInt(5, Integer.parseInt(identifiant));
			nbexe=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(nbexe==0) {
			return false;
		}
		else {
			return true;
		}		
	}
	
	public void setMachineSalle(Machine machine){
		Salle salle = machine.getSalle();
		try {
			Connection con =BD.getConnection();
			PreparedStatement sql = con.prepareStatement( "INSERT INTO machine(IDM, IDS, NOMM, ETATM) VALUES (?, ?, ?, ?)");
			sql.setInt(1, this.trouverMaxMachine());
			sql.setInt(2, this.chercherIdSalle(salle));
			sql.setString(3, machine.getNomMachine());
			sql.setString(4, machine.getEtatMachine());
			sql.executeUpdate();		
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }		
		};
		
		private int trouverMaxMachine() {
			String sql="SELECT max(idm) FROM machine";
			int nbIDM=0;
			try {
			Connection con = BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery(sql);
			while (rs.next()) {
				nbIDM=rs.getInt(1);
				nbIDM++;
			}
			rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return nbIDM;
		}
}