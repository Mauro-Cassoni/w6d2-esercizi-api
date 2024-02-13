package it.epicode.w6d2.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Autore {

    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }


}
