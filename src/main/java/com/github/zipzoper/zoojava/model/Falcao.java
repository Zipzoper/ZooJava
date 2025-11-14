package com.github.zipzoper.zoojava.model;

public class Falcao extends Ave {

    public Falcao(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + ": Kreeeeeee!");
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " come pequenos roedores.");
    }
}
