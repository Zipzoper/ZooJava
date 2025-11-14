package com.github.zipzoper.zoojava.model;

public class PeixePalhaco extends Peixe {

    public PeixePalhaco(String nome, int idade, String especie) {
        super(nome, idade,  especie);
    }

    @Override
    public void emitirSom() {
        // não faz sons audíveis
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " come algas.");
    }
}
