/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author feder
 */
public class ReaderXML {

   public static void main (String[] args) {

      try {
         File inputFile = new File("Rubrica.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("Persona");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Nome : " 
                  + eElement
                  .getElementsByTagName("nome")
                  .item(0)
                  .getTextContent());
               System.out.println("Cognome : " 
                  + eElement
                  .getElementsByTagName("cognome")
                  .item(0)
                  .getTextContent());
               System.out.println("Numero : " 
                  + eElement
                  .getElementsByTagName("numero")
                  .item(0)
                  .getTextContent());

            }
         }
      } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
      }
   }
}

