/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricafxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Federico Gavazzi, Michele Potettu
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button aggiungiBtn;
    @FXML
    private Button rimuoviBtn;
    @FXML
    private Label titoloLbl;
    @FXML
    private TextField ricercaTxt;
    @FXML
    private ScrollPane contattiPane;
    @FXML
    private AnchorPane paneInterno;
    @FXML
    private Label labelContatti;
    private GestoreContatti gest;
    @FXML
    private Button addBtn;
    @FXML
    private TextField nomeTxt;
    @FXML
    private TextField cognomeTxt;
    @FXML
    private TextField numeroTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private Label addLbl;
    @FXML
    private Button backBtn;
    @FXML
    private ButtonBar buttonBar;
    private TextField testo[];
    @FXML
    private Button moinBtn;
    @FXML
    private Label removeLbl;
    @FXML
    private Label informationLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gest = new GestoreContatti(Lettore.carica("rubrica.xml"));
        labelContatti.setText(gest.toString());
        testo = new TextField[4];
        testo[0] = nomeTxt;
        testo[1] = cognomeTxt;
        testo[2] = numeroTxt;
        testo[3] = emailTxt;
        for (TextField t : testo) {
            t.setVisible(false);
        }
        addBtn.setVisible(false);
        backBtn.setVisible(false);
        addLbl.setVisible(false);
        contattiPane.setVisible(true);
        titoloLbl.setVisible(true);
        ricercaTxt.setVisible(true);
        buttonBar.setVisible(true);
        removeLbl.setVisible(false);
        informationLbl.setVisible(false);
        moinBtn.setVisible(false);
        informationLbl.setText("");

    }
    //visualizza rubrica
    //aggiungi e togli contatto
    //ricerca per cognome + ricerca per nome

    @FXML
    private void aggiungiContatto(ActionEvent event) {
        //text field da mettere e nominare
        //controlli da fare
        titoloLbl.setVisible(false);
        contattiPane.setVisible(false);
        ricercaTxt.setVisible(false);
        buttonBar.setVisible(false);
        int y = 186;
        for (TextField t : testo) {
            t.setLayoutY(y);
            t.setVisible(true);
            y+=70;
        }
        addBtn.setVisible(true);
        backBtn.setVisible(true);
        addLbl.setVisible(true);
    }

    @FXML
    private void rimuoviContatto(ActionEvent event) {
        removeLbl.setVisible(true);
        nomeTxt.setVisible(true);
        numeroTxt.setVisible(true);
        informationLbl.setVisible(true);
        moinBtn.setVisible(true);
        backBtn.setVisible(true);
        titoloLbl.setVisible(false);
        contattiPane.setVisible(false);
        ricercaTxt.setVisible(false);
        buttonBar.setVisible(false);
        informationLbl.setText(gest.toString());
        numeroTxt.setLayoutY(459);
        
    }

    @FXML
    private void ricercaContatto(KeyEvent event) {
        String s = "Nome     Cognome        Numero                 Email\n";
        for (Contatto c : gest.ricerca(ricercaTxt.getText())) {
            s += c + "\n";
        }
        labelContatti.setText(s);
        if (ricercaTxt.getText().length() == 0) {
            labelContatti.setText(gest.toString());
        }
    }

    @FXML
    private void aggiungiNuovo(ActionEvent event) {
        gest.aggiungi(new Contatto(nomeTxt.getText(), cognomeTxt.getText(), numeroTxt.getText(), emailTxt.getText()));
        nomeTxt.clear();
        cognomeTxt.clear();
        numeroTxt.clear();
        emailTxt.clear();
        labelContatti.setText(gest.toString());
        titoloLbl.setVisible(true);
        contattiPane.setVisible(true);
        ricercaTxt.setVisible(true);
        buttonBar.setVisible(true);
        for (TextField t : testo) {
            t.setVisible(false);
        }
        addBtn.setVisible(false);
        backBtn.setVisible(false);
        addLbl.setVisible(false);
        Scrittore.scrivi(gest.getRubrica(), "rubrica.xml");
    }

    @FXML
    private void indietro(ActionEvent event) {
        titoloLbl.setVisible(true);
        contattiPane.setVisible(true);
        ricercaTxt.setVisible(true);
        buttonBar.setVisible(true);
        for (TextField t : testo) {
            t.setVisible(false);
        }
        addBtn.setVisible(false);
        backBtn.setVisible(false);
        addLbl.setVisible(false);
        informationLbl.setVisible(false);
        removeLbl.setVisible(false);
        moinBtn.setVisible(false);
    }

    @FXML
    private void rimuoviPresente(ActionEvent event) {
        gest.rimuovi(gest.ricercaNumero(numeroTxt.getText()));
        nomeTxt.clear();
        numeroTxt.clear();
        labelContatti.setText(gest.toString());
        titoloLbl.setVisible(true);
        contattiPane.setVisible(true);
        ricercaTxt.setVisible(true);
        buttonBar.setVisible(true);
        removeLbl.setVisible(false);
        for (TextField t : testo) {
            t.setVisible(false);
        }
        backBtn.setVisible(false);
        moinBtn.setVisible(false);
        informationLbl.setVisible(false);
        Scrittore.scrivi(gest.getRubrica(), "rubrica.xml");
        
    }

    @FXML
    private void ricercaContattoEliminazione(KeyEvent event) {
        String s = "Nome     Cognome        Numero                 Email\n";
        for (Contatto c : gest.ricerca(nomeTxt.getText())) {
            s += c + "\n";
        }
        informationLbl.setText(s);
        if (nomeTxt.getText().length() == 0) {
            informationLbl.setText(gest.toString());
        }
        
        
    }
}
