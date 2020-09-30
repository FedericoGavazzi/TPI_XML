/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricafxml;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author feder
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gest = new GestoreContatti(Lettore.carica("rubrica.xml"));
        labelContatti.setText(gest.toString());
        
    }    
    //visualizza rubrica
    //aggiungi e togli contatto
    //ricerca per cognome + ricerca per nome

    @FXML
    private void aggiungiContatto(ActionEvent event) {
    //text field da mettere e nominare
    //controlli da fare
    }

    @FXML
    private void rimuoviContatto(ActionEvent event) {
    //controlli da fare
    //textfield da mettere e nominare
    }


    @FXML
    private void ricercaContatto(KeyEvent event) {
        String s = "Nome     Cognome        Numero                 Email\n";
        for(Contatto c : gest.ricerca(ricercaTxt.getText()))
            s+=c + "\n";
                labelContatti.setText(s);
        if(ricercaTxt.getText().length() == 0)
            labelContatti.setText(gest.toString());
    }
}
