Classe Zoologico:
 
//package br.com.zoojava.controller;
 
//import br.com.zoojava.model.*;
import java.util.ArrayList;
import java.util.List;
 
public class Zoologico {
    private List<Animal> animais = new ArrayList<>();
 
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
        for (Animal a : animais) a.emitirSom();
    }
 
    public void alimentarTodos() {
        for (Animal a : animais) a.alimentar();
    }
 
    public void removerAnimal(int index) {
        if (index >= 0 && index < animais.size()) {
            System.out.println(animais.remove(index).getNome() + " foi removido!");
        } else {
            System.out.println("Índice inválido.");
        }
    }
 
    public List<Animal> getAnimais() {
        return animais;
    }
}
