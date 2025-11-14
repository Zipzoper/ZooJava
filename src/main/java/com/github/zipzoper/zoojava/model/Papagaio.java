package com.github.zipzoper.zoojava.model;

public class Papagaio extends Ave {

    public Papagaio(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + ": Curupaco!");
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " come sementes e frutas.");
    }
}
