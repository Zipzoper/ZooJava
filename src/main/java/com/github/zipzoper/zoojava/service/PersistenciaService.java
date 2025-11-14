package com.github.zipzoper.zoojava.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.github.zipzoper.zoojava.model.*;

public class PersistenciaService {

    private static final String DIRETORIO = "data";
    private static final String ARQUIVO = DIRETORIO + "/zoo.txt";

    public PersistenciaService() {
        criarDiretorioSeNaoExistir();
    }

    private void criarDiretorioSeNaoExistir() {
        Path path = Paths.get(DIRETORIO);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                System.out.println("📁 Pasta 'data' criada com sucesso.");
            } catch (IOException e) {
                System.out.println("❌ Erro ao criar pasta 'data': " + e.getMessage());
            }
        }
    }

    // -------------------------------------------------------------
    // SALVAR TODOS OS ANIMAIS
    // -------------------------------------------------------------
    public void salvar(List<Animal> animais) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(ARQUIVO, false))) {

            for (Animal a : animais) {

                String tipo = a.getClass().getSimpleName();
                String nome = a.getNome();
                int idade = a.getIdade();
                String especie = a.getEspecie();

                // Macaco tem atributo extra
                if (a instanceof Macaco) {
                    Macaco m = (Macaco) a;
                    w.write(tipo + ";" + nome + ";" + idade + ";" + especie + ";" + m.getBananasComidas());
                } else {
                    // todos os outros animais não têm atributos extras
                    w.write(tipo + ";" + nome + ";" + idade + ";" + especie);
                }

                w.newLine();
            }
        }
    }

    // -------------------------------------------------------------
    // CARREGAR TODOS OS ANIMAIS
    // -------------------------------------------------------------
    public List<Animal> carregar() throws IOException {

        List<Animal> lista = new ArrayList<>();

        Path path = Paths.get(ARQUIVO);
        if (!Files.exists(path)) {
            return lista;
        }

        try (BufferedReader r = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;
            while ((linha = r.readLine()) != null) {
                if (linha.isBlank()) continue;

                String[] p = linha.split(";");

                String tipo = p[0];
                String nome = p[1];
                int idade = Integer.parseInt(p[2]);
                String especie = p[3];

                Animal a = null;

                switch (tipo) {

                    // 🦁 MAMÍFEROS
                    case "Macaco":
                        int bananas = p.length > 4 ? Integer.parseInt(p[4]) : 0;
                        Macaco m = new Macaco(nome, idade, especie);
                        m.setBananasComidas(bananas);
                        a = m;
                        break;

                    case "Leao":
                        a = new Leao(nome, idade, especie);
                        break;

                    case "Elefante":
                        a = new Elefante(nome, idade, especie);
                        break;

                    // 🐦 AVES
                    case "Papagaio":
                        a = new Papagaio(nome, idade, especie);
                        break;

                    case "Falcao":
                        a = new Falcao(nome, idade, especie);
                        break;

                    // 🐍 RÉPTEIS
                    case "Cobra":
                        a = new Cobra(nome, idade, especie);
                        break;

                    case "Tartaruga":
                        a = new Tartaruga(nome, idade, especie);
                        break;

                    // 🐠 PEIXES
                    case "Tubarao":
                        a = new Tubarao(nome, idade, especie);
                        break;

                    case "PeixePalhaco":
                        a = new PeixePalhaco(nome, idade, especie);
                        break;

                    // 🐛 INVERTEBRADOS
                    case "Aranha":
                        a = new Aranha(nome, idade, especie);
                        break;

                    case "Formiga":
                        a = new Formiga(nome, idade, especie);
                        break;

                    default:
                        System.out.println("⚠ Tipo desconhecido no arquivo: " + tipo);
                }

                if (a != null) lista.add(a);
            }
        }

        return lista;
    }
}
