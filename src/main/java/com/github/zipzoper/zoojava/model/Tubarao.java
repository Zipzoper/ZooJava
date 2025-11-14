package com.github.zipzoper.zoojava.model;

public class Tubarao extends Peixe {

    public Tubarao(String nome, int idade, String especie) {
        super(nome, idade,  especie);
    }

    @Override
    public void emitirSom() {
        // tubarões não produzem som audível
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " se alimenta de outros peixes.");
    }
}
