package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.lab04.model.Corso;


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
	
	public List<Corso> getCorsiFrequentati(int matricola){
		String sql = "SELECT *\n" + 
				"FROM corso\n" + 
				"WHERE codins IN (SELECT codins\n" + 
				"						FROM iscrizione\n" + 
				"						WHERE matricola = ? )";
		List<Corso> corsi = new ArrayList<Corso>();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String codins = rs.getString("codins");
				String nome = rs.getString("nome");
				int crediti = rs.getInt("crediti");
				int pd = rs.getInt("pd");
				Corso c = new Corso(codins,crediti,nome,pd);
				corsi.add(c);
			}
			return corsi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return corsi;
		
		
		
		
	}
}
