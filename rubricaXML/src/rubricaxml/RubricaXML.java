/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaxml;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Federico Gavazzi
 */
public class RubricaXML {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        File obj = new File("Rubrica.xml");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(obj))) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
            writer.write("<Rubrica>\n");
            writer.write("<Persona>\n");
            writer.write("<nome>Federico</nome>\n");
            writer.write("<cognome>Gavazzi</cognome>\n");
            writer.write("<numero>3907763456</numero>\n");
            writer.write("</Persona>\n");
            writer.write("<Persona>\n");
            writer.write("<nome>Ginevra</nome>\n");
            writer.write("<cognome>Arici</cognome>\n");
            writer.write("<numero>373454569</numero>\n");
            writer.write("</Persona>\n");
            writer.write("<Persona>\n");
            writer.write("<nome>Gianni</nome>\n");
            writer.write("<cognome>Saluti</cognome>\n");
            writer.write("<numero>336563789</numero>\n");
            writer.write("</Persona>\n");
            writer.write("</Rubrica>\n");
        }
        

    }

}
