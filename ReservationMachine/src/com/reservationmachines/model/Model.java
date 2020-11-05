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
import java.util.TimeZone;

public class Model extends AbstractModel {

	@Override
	public String[] getEnteteReservationMachine() {
		return new String[] {"Machine", "état de la machine", "Nom étudiant", "Prénom étudiant"};
	}
	
	public Model() {
		super();
		// TODO Auto-generated constructor stub
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
	
	// ajouter une nouvelle salle
	public void ajoutSalle(String nomSalle){
        try {
		Connection con =BD.getConnection();
		PreparedStatement sql = con.prepareStatement( "insert into salle(noms) values(?);");
		sql.setString(1, nomSalle);
		sql.executeUpdate();		
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }		
	};

	//Trouver une etudiant selon son identifiant
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
			
			System.out.println("Je suis l� !");
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
	public boolean misAjourInBD(String stremail, String strRePwd,String id) {
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
			
			System.out.println("Je suis l� !");
		} catch (Exception e) {e.printStackTrace();}
		
		return admin;
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
		String sqlinsertrec="INSERT INTO reclamation (idr,typer, descriptionr) VALUES (?,?,?);";
		int idr=this.trouverMaxReclamation();
		try {
			Connection con =BD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sqlinsertrec);
			pstmt.setInt(1,idr);
			pstmt.setString(2, String.valueOf(re.getType()));
			pstmt.setString(3, re.getDescription());
			n=pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		System.out.println(re.getRm().getEtudiant().getIdentifiant()+"---------");
		System.out.println(re.getRm().getNomMachine()+"+++++++");
		System.out.println(this.trouverNumeroM(re.getRm().getNomMachine())+"////////");
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
}
