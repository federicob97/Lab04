package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	
	public void setModel(Model model) {
		this.model = model;
		boxCorso.setItems(model.getNomiCorsi());
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxCorso;

    @FXML
    private Button buttonCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private CheckBox spunta;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button buttonCercaCorsi;

    @FXML
    private Button buttonIscrivi;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button buttonReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	String corso = boxCorso.getValue();
    	String iscritti = model.getIscritti(corso);
    	txtArea.setText(iscritti);
    }

    @FXML
    void doCompleta(ActionEvent event) {
    	txtCognome.clear();
    	txtNome.clear();
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	String x = model.getStudente(matricola);
    	if(x.contains(";")) {
    		String[] s = x.split(";");
    		txtCognome.setText(s[0]);
    		txtNome.setText(s[1]);
    	}
    	else {
    		txtArea.setText(x);
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCognome.clear();
    	txtNome.clear();
    	txtArea.clear();
    }

    @FXML
    void initialize() {
        assert boxCorso != null : "fx:id=\"boxCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert buttonCercaIscritti != null : "fx:id=\"buttonCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert spunta != null : "fx:id=\"spunta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert buttonCercaCorsi != null : "fx:id=\"buttonCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert buttonIscrivi != null : "fx:id=\"buttonIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert buttonReset != null : "fx:id=\"buttonReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}

