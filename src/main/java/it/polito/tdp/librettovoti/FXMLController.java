package it.polito.tdp.librettovoti;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.libretto;
import model.voto;

public class FXMLController {
	
	private libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAggiungi;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextArea txtVoti;

    @FXML
    void handleAggiungi(ActionEvent event) {
    	//1. acquisizione e controllo dati
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();
    	
    	//controlli di validità
    	if(nome.equals("") || punti==null) {
    		//errore, non posso eseguire l'operazione
    		txtVoti.setDisable(false);
    		txtVoti.setText("ERRORE: occorre inserire nome e voto \n");
    		return; 
    	}
    		
    		
    	//2. esecuzione dell'operazione (==chiedere al Model di farla)
    	model.add(new voto (nome, punti));
    	
    	//3. visualizzazione/aggiornamento del risultato
    	
    	txtNome.clear();
    	cmbPunti.setValue(null);
    }
  
    public void setModel(libretto model) {
    	this.model = model;
    	
    	List<voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato " +voti.size()+ " esami \n");
    	for(voto v: voti) {
    		txtVoti.appendText(v.toString() + "\n");
    	}
    	
    }
    
    @FXML
    void initialize() {
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbPunti.getItems().clear();
        for(int p=18; p<=30; p++) {
        	cmbPunti.getItems().add(p);
        }
    }

}
