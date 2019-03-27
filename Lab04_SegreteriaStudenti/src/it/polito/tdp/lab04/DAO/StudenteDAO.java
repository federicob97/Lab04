package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudenteDAO {

	
	public String getStudente(int matricola) {
		final String sql = "SELECT cognome,nome FROM studente WHERE matricola = ?";
		String s = null;
		Connection conn = ConnectDB.getConnection();
		
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				s = cognome+" "+nome;
			}
			else
				s="";
			
			conn.close();
			return s;
			

		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
}
