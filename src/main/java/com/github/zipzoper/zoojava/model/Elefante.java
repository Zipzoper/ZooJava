package com.github.zipzoper.zoojava.model;

public class Elefante extends Mamifero {
    public Elefante() { super("Elefante", 0, "Elefante"); }
    public Elefante(String nome, int idade) {
        super(nome, idade, "Elefante");
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
