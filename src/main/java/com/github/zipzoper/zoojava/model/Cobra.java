package com.github.zipzoper.zoojava.model;

public class Cobra extends Reptil {

    public Cobra(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + ": Sssssss...");
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " engole presas inteiras.");
    }
}
