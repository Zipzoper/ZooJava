package com.github.zipzoper.zoojava.model;

public class Formiga extends Invertebrado {

    public Formiga(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    @Override
    public void emitirSom() {
        // não faz som
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " Comeur folhas.");
    }
}
