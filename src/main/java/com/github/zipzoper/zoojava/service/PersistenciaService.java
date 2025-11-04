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

import com.github.zipzoper.zoojava.model.Animal;
import com.github.zipzoper.zoojava.model.Elefante;
import com.github.zipzoper.zoojava.model.Leao;
import com.github.zipzoper.zoojava.model.Macaco;

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

    /**
     * Salva todos os animais no arquivo zoo.txt
     * Formatos:
     *  - Macaco;Nome;Idade;BananasComidas
     *  - Leao;Nome;Idade
     *  - Elefante;Nome;Idade
     */
    public void salvar(List<Animal> animais) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, false))) {

            for (Animal a : animais) {
                if (a instanceof Macaco) {
                    Macaco m = (Macaco) a;
                    writer.write("Macaco;" + m.getNome() + ";" + m.getIdade() + ";" + m.getBananasComidas());
                } else if (a instanceof Leao) {
                    writer.write("Leao;" + a.getNome() + ";" + a.getIdade());
                } else if (a instanceof Elefante) {
                    writer.write("Elefante;" + a.getNome() + ";" + a.getIdade());
                }
                writer.newLine();
            }
        }
    }

    /**
     * Lê o arquivo zoo.txt e reconstrói os objetos
     */
    public List<Animal> carregar() throws IOException {
        List<Animal> lista = new ArrayList<>();

        Path path = Paths.get(ARQUIVO);
        if (!Files.exists(path)) {
            return lista; // Arquivo não existe → lista vazia
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {

                if (linha.isBlank()) continue;

                String[] partes = linha.split(";");

                String tipo = partes[0];
                String nome = partes[1];
                int idade = Integer.parseInt(partes[2]);

                switch (tipo) {
                    case "Macaco":
                        int bananas = Integer.parseInt(partes[3]);
                        Macaco m = new Macaco(nome, idade);
                        m.setBananasComidas(bananas);
                        lista.add(m);
                        break;

                    case "Leao":
                        lista.add(new Leao(nome, idade));
                        break;

                    case "Elefante":
                        lista.add(new Elefante(nome, idade));
                        break;

                    default:
                        System.out.println("⚠ Tipo desconhecido no arquivo: " + tipo);
                }
            }
        }

        return lista;
    }
}
