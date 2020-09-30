/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricafxml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author feder
 */
public class Lettore {

    public static ArrayList<Contatto> carica(String nomeFile) {
            ArrayList<Contatto> rubrica = new ArrayList<>();
        try {
            File inputFile = new File(nomeFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("contatto");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Contatto contatto = new Contatto(
                    eElement.getElementsByTagName("nome").item(0).getTextContent(),
                    eElement.getElementsByTagName("cognome").item(0).getTextContent(),
                    eElement.getElementsByTagName("numero_telefono").item(0).getTextContent(),
                    eElement.getElementsByTagName("email").item(0).getTextContent());
                    rubrica.add(contatto);
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }
        return rubrica;
    }

}
