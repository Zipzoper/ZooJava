package com.github.zipzoper.zoojava.view;

import com.github.zipzoper.zoojava.controller.Zoologico;
import com.github.zipzoper.zoojava.model.*;
import com.github.zipzoper.zoojava.service.PersistenciaService;
import com.github.zipzoper.zoojava.util.InputUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    // ANSI colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLUE = "\u001B[34m";

    private static Zoologico zoo = new Zoologico();
    private static PersistenciaService persist = new PersistenciaService();

    public static void main(String[] args) {

        System.out.println(CYAN + "🦁 ZooJava - Versão Funcional (.TXT Persistence)" + RESET);

        // Carregar dados do arquivo .txt
        try {
            List<Animal> carregados = persist.carregar();
            if (!carregados.isEmpty()) {
                zoo.setAnimais(carregados);
                System.out.println(GREEN + "✔ Dados carregados de data/zoo.txt (" + carregados.size() + " animais)" + RESET);
            } else {
                System.out.println(YELLOW + "⚠ Nenhum arquivo encontrado. Lista iniciada vazia." + RESET);
            }
        } catch (IOException e) {
            System.out.println(RED + "❌ Erro ao carregar dados: " + e.getMessage() + RESET);
        }

        int opcao;
        do {
            mostrarMenu();
            opcao = InputUtils.lerInt("");
            switch (opcao) {
                case 1 -> cadastrarAnimal();
                case 2 -> zoo.listarAnimais();
                case 3 -> zoo.emitirSomTodos();
                case 4 -> zoo.alimentarTodos();
                case 5 -> removerAnimal();
                case 6 -> exibirEstatisticas();
                case 0 -> sair();
                default -> System.out.println(RED + "Opção inválida!" + RESET);
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n" + BLUE + "===== MENU ZOOJAVA =====" + RESET);
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Listar animais");
        System.out.println("3 - Emitir som de todos");
        System.out.println("4 - Alimentar todos");
        System.out.println("5 - Remover animal");
        System.out.println("6 - Estatísticas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarAnimal() {
        System.out.println("\n--- Cadastro de Animal ---");
        String nome = InputUtils.lerString("Nome: ");
        int idade = InputUtils.lerInt("Idade: ");
        System.out.println("Tipo (1-Macaco, 2-Leão, 3-Elefante): ");
        int tipo = InputUtils.lerInt("");

        Animal a = null;
        switch (tipo) {
            case 1 -> a = new Macaco(nome, idade);
            case 2 -> a = new Leao(nome, idade);
            case 3 -> a = new Elefante(nome, idade);
            default -> System.out.println(RED + "Tipo inválido." + RESET);
        }
        if (a != null) zoo.adicionarAnimal(a);
    }

    private static void removerAnimal() {
        zoo.listarAnimais();
        int index = InputUtils.lerInt("Informe o número do animal para remover: ") - 1;
        zoo.removerAnimal(index);
    }

    private static void exibirEstatisticas() {
        Map<String, Integer> stats = zoo.contarAnimaisPorEspecie();
        if (stats.isEmpty()) {
            System.out.println(YELLOW + "Nenhum animal cadastrado." + RESET);
            return;
        }
        System.out.println("\n📊 Quantidade de animais por espécie:");
        stats.forEach((tipo, qtd) -> System.out.println(tipo + ": " + qtd));
    }

    private static void sair() {
        System.out.println("\nDeseja salvar as alterações antes de sair? (S/N)");
        String resp = InputUtils.lerStringOpcao("> ");

        if (resp.equalsIgnoreCase("S")) {
            try {
                persist.salvar(zoo.getAnimais());
                System.out.println(GREEN + "✔ Dados salvos em data/zoo.txt" + RESET);
            } catch (IOException e) {
                System.out.println(RED + "❌ Erro ao salvar: " + e.getMessage() + RESET);
            }
        } else {
            System.out.println(YELLOW + "Alterações não salvas." + RESET);
        }

        System.out.println(CYAN + "Encerrando ZooJava. Obrigado!" + RESET);
    }
}
