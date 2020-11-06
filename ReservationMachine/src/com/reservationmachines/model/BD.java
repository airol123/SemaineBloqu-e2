package com.reservationmachines.model;

import java.sql.*;

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
			System.out.println("Succ�s driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("pb: Class.forName");
		}

		try {
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Succ�s Connexion");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("pb:JDBC ");
		}
		return con;
	}
	//Pour tester 
	/*
    public Etudiant seConnecter(String ide) throws SQLException {
		Etudiant etu=null;
		String sqletudiant = "select * from etudiant where ide=?";
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
	}*/

	public static void main(String[] args) throws SQLException {
		con = BD.getConnection(); 
		//Pour tester
		//Etudiant e=c.seConnecter(Integer.toString(21809051));  
		//System.out.println(e.getEmail());
	}
}



