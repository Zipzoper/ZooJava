package com.github.zipzoper.zoojava.model;

public class Tartaruga extends Reptil {

    public Tartaruga(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    @Override
    public void emitirSom() {
        // não possui som
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " come vegetais e pequenos insetos.");
    }
}
