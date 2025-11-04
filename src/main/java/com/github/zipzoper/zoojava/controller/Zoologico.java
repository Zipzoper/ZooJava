package com.github.zipzoper.zoojava.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.zipzoper.zoojava.model.Animal;

public class Zoologico {
    private List<Animal> animais = new ArrayList<>();

    public Zoologico() {}

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void adicionarAnimal(Animal a) {
        animais.add(a);
        System.out.println("Animal adicionado com sucesso!");
    }

    public void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (int i = 0; i < animais.size(); i++) {
                System.out.println((i + 1) + " - " + animais.get(i));
            }
        }
    }

    public void emitirSomTodos() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado para emitir som.");
            return;
        }
        for (Animal a : animais) a.emitirSom();
    }

    public void alimentarTodos() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado para alimentar.");
            return;
        }
        for (Animal a : animais) a.alimentar();
    }

    public void removerAnimal(int index) {
        if (index >= 0 && index < animais.size()) {
            System.out.println(animais.remove(index).getNome() + " foi removido!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public Map<String, Integer> contarAnimaisPorEspecie() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Animal a : animais) {
            mapa.put(a.getEspecie(), mapa.getOrDefault(a.getEspecie(), 0) + 1);
        }
        return mapa;
    }
}
