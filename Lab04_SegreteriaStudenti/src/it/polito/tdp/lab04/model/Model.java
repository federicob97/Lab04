package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	private List<Corso> corsi;
	private List<Studente> studenti;
	private StudenteDAO sdao;
	
	public Model() {
		CorsoDAO c = new CorsoDAO();
		sdao = new StudenteDAO();
		this.corsi = c.getTuttiICorsi();
		this.studenti = new LinkedList<Studente>();
	}
	
	public ObservableList<String> getNomiCorsi(){
		List<String> res = new ArrayList<String>();
		for(Corso c : corsi) {
			res.add(c.getNome());
		}
		res.add("");
		ObservableList<String> xxx = FXCollections.observableList(res);
		return xxx;
	}
	public String getStudente(int matricola) {
		String s = sdao.getStudente(matricola);
		return s;
	}
	
}
