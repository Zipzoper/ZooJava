package com.github.zipzoper.zoojava.model;

public class Macaco extends Mamifero {

    private int bananasComidas = 0;

    public Macaco(String nome, int idade, String especie) {
        super(nome, idade, especie);
    }

    public Macaco(String nome, int idade) {
        this(nome, idade, "Macaco");
    }

    public Macaco() {
        this("Macaco", 0, "Macaco");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " gritou: Uh uh ah ah!");
    }

    @Override
    public void alimentar() {
        bananasComidas++;
        System.out.println(getNome() + " comeu uma banana! Total: " + bananasComidas);
    }

    public int getBananasComidas() {
        return bananasComidas;
    }

    public void setBananasComidas(int bananasComidas) {
        this.bananasComidas = bananasComidas;
    }
}
