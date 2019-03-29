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
	private CorsoDAO cdao;
	
	public Model() {
		cdao = new CorsoDAO();
		sdao = new StudenteDAO();
		this.corsi = cdao.getTuttiICorsi();
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
	public String getIscritti(String corso){
		List<Studente> iscritti = new ArrayList<Studente>(cdao.getStudentiIscrittiAlCorso(corso));
		String i = new String();
		for(Studente x : iscritti) {
			i+=x.getMatricola()+" "+x.getCognome()+" "+x.getNome()+" "+x.getCds()+"\n";
		}
		return i;
	}
	public String getCorsiFrequentati(int matricola) {
		List<Corso> corsi = new ArrayList<Corso>(sdao.getCorsiFrequentati(matricola));
		if(corsi.isEmpty())
			return "Matricola errata";
		else {
			String x = new String();
			for(Corso c : corsi) {
				x+= c.getCodins()+" "+c.getCrediti()+" "+c.getNome()+" "+c.getPd()+"\n";
			}
			return x;
		}
	}
	public boolean isIscritto(int matricola, String nomeCorso) {
		String corsi = this.getCorsiFrequentati(matricola);
		if(corsi.contains(nomeCorso))
			return true;
		else
			return false;
	}
	
}
