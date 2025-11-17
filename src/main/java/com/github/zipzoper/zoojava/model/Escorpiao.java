package com.github.zipzoper.zoojava.model;

public class Escorpiao extends Invertebrado {

    public Escorpiao(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    

    @Override
    public void emitirSom() {
        // não faz som
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " Come Baratas.");
    }
}
