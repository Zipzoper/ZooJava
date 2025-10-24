Classe Main:
 
//package br.com.zoojava.view;
 
//import br.com.zoojava.model.*;
//import br.com.zoojava.controller.Zoologico;
//import br.com.zoojava.util.InputUtils;
 
public class Main {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();
        int opcao;
 
        do {
            System.out.println("\n===== MENU ZOOJAVA =====");
            System.out.println("1 - Cadastrar animal");
            System.out.println("2 - Listar animais");
            System.out.println("3 - Emitir som");
            System.out.println("4 - Alimentar todos");
            System.out.println("5 - Remover animal");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
 
            opcao = InputUtils.lerInt("");
 
            switch (opcao) {
                case 1 -> cadastrarAnimal(zoo);
                case 2 -> zoo.listarAnimais();
                case 3 -> zoo.emitirSomTodos();
                case 4 -> zoo.alimentarTodos();
                case 5 -> removerAnimal(zoo);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
 
    private static void cadastrarAnimal(Zoologico zoo) {
        System.out.println("\n--- Cadastro de Animal ---");
        String nome = InputUtils.lerString("Nome: ");
        int idade = InputUtils.lerInt("Idade: ");
        System.out.println("Tipo (1-Macaco, 2-Leão, 3-Elefante): ");
        int tipo = InputUtils.lerInt("");
 
        Animal a = switch (tipo) {
            case 1 -> new Macaco(nome, idade);
            case 2 -> new Leao(nome, idade);
            case 3 -> new Elefante(nome, idade);
            default -> null;
        };
 
        if (a != null) zoo.adicionarAnimal(a);
        else System.out.println("Tipo inválido.");
    }
 
    private static void removerAnimal(Zoologico zoo) {
        zoo.listarAnimais();
        int index = InputUtils.lerInt("Informe o número do animal para remover: ") - 1;
        zoo.removerAnimal(index);
    }
}
