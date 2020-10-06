package rubricafxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Federico Gavazzi, Michele Potettu
 */
public class Contatto {

    private String nome;
    private String cognome;
    private String numero_telefono;
    private String email;

    public Contatto(String nome, String cognome, String numero_telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero_telefono = numero_telefono;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean nomeUguale(String nome){
        String temp = nome;
        if(temp.length() == 1)
            temp = temp.toUpperCase();
        return this.nome.equalsIgnoreCase(nome) || this.nome.contains(nome) || this.nome.contains(temp);
            
    }
    
    public boolean cognomeUguale(String cognome){
        String temp = cognome;
        if(temp.length() == 1)
            temp = temp.toUpperCase();
        return this.cognome.equalsIgnoreCase(cognome) || this.cognome.contains(cognome) || this.cognome.contains(temp);
    }
    
    public boolean numeroUguale (String numero){
        return this.numero_telefono.equals(numero);
    }

    @Override
    public String toString() {
        return "Nome:  " + nome + "      Cognome:  " + cognome + "        Numero:  " + numero_telefono + "       Email:  " + email;
    }
    
    
}
