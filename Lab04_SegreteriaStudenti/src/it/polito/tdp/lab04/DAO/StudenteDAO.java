package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudenteDAO {

	
	public String getStudente(int matricola) {
		String sql = "SELECT cognome,nome FROM studente WHERE matricola = ?";
		Connection con = ConnectDB.getConnection();
		PreparedStatement st;
		String s = new String();
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				s=cognome+";"+nome;
			}else
				s="Nessuna corrispondenza";
			//con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return s;
	}
}
