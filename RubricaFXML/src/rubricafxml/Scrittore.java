/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricafxml;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author feder
 */
public class Scrittore {

    public void scrivi(ArrayList<Contatto> rubrica, String nomeFile) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("rubrica");
            document.appendChild(root);
            for (Contatto c : rubrica) {
                Element contatto = document.createElement("contatto");
                Element nome = document.createElement("nome");
                nome.appendChild(document.createTextNode(c.getNome()));
                contatto.appendChild(nome);
                Element cognome = document.createElement("cognome");
                cognome.appendChild(document.createTextNode(c.getCognome()));
                contatto.appendChild(cognome);
                Element numero = document.createElement("numero");
                numero.appendChild(document.createTextNode(c.getNumero_telefono()));
                contatto.appendChild(numero);
                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(c.getEmail()));
                contatto.appendChild(email);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File(nomeFile));
                transformer.transform(domSource, streamResult);
            }
        } catch (ParserConfigurationException | TransformerException ex) {
        }

    }
}
