package rubricafxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author feder
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
        return this.nome.equalsIgnoreCase(nome);
    }
    public boolean cognomeUguale(String cognome){
        return this.cognome.equalsIgnoreCase(cognome);
    }

    @Override
    public String toString() {
        return nome + "    " + cognome + "     " + numero_telefono + "     " + email;
    }
    
    
}
