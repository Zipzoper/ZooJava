package com.github.zipzoper.zoojava.model;

public class Elefante extends Mamifero {

    public Elefante(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    public Elefante(String nome, int idade) {
        this(nome, idade, "Elefante");
    }

    public Elefante() {
        this("Elefante", 0, "Elefante");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " trombetou: Prrrrrrr!");
    }

    @Override
    public void alimentar() {
        System.out.println(getNome() + " comeu amendoins!");
    }
}
