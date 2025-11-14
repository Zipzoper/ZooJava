package com.github.zipzoper.zoojava.model;

public class Aranha extends Invertebrado {

    public Aranha(String nome, int idade, String especie) {
        super(nome, idade,  especie);
    }

    @Override
    public void emitirSom() {
        // não faz som
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " come insetos capturados na teia.");
    }
}
