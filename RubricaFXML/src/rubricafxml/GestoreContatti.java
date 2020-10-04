/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricafxml;

import java.util.ArrayList;

/**
 *
 * @author Federico Gavazzi, Michele Potettu
 */
public class GestoreContatti {
    //salvataggi ricerca etc..
    private ArrayList<Contatto> rubrica;
    
    public GestoreContatti(){
        rubrica = new ArrayList<>();
    }
    
    public GestoreContatti(ArrayList<Contatto> r){
        rubrica = r;
    }
    
    public boolean aggiungi(Contatto c){
        rubrica.add(c);
        return true;
    }
    
    public boolean rimuovi(Contatto c){
        rubrica.remove(c);
        return true;
    }
    public ArrayList<Contatto> ricerca(String nominativo){
        ArrayList<Contatto> risultato = ricercaNome(nominativo);
        risultato.addAll(ricercaCognome(nominativo));
        return risultato;
    }
    
    private ArrayList<Contatto> ricercaNome(String nome){
        ArrayList<Contatto> ricerca = new ArrayList<>();
        for(Contatto c : rubrica){
            if(c.nomeUguale(nome))
                ricerca.add(c);
        }
        return ricerca;
    }

    private ArrayList<Contatto> ricercaCognome(String cognome){
        ArrayList<Contatto> ricerca = new ArrayList<>();
        for(Contatto c : rubrica){
            if(c.cognomeUguale(cognome))
                ricerca.add(c);
        }
        return ricerca;
    }
    
    public Contatto ricercaNumero(String numero){
        for(Contatto c : rubrica){
            if(c.numeroUguale(numero))
                return c;
        }
        return null;
    }

    public ArrayList<Contatto> getRubrica() {
        return rubrica;
    }

    public void setRubrica(ArrayList<Contatto> rubrica) {
        this.rubrica = rubrica;
    }
    
    @Override
    public String toString(){
        String s = " Nome     Cognome        Numero                 Email\n";
        for(Contatto c : rubrica)
            s+=c + "\n";
        return s;
    }
    
    
}
