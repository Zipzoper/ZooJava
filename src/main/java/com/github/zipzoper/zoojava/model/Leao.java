package com.github.zipzoper.zoojava.model;

public class Leao extends Mamifero {

    public Leao(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    public Leao(String nome, int idade) {
        this(nome, idade, "Leão");
    }

    public Leao() {
        this("Leão", 0, "Leão");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " rugiu: Rooooar!");
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " comeu carne!");
    }
}
