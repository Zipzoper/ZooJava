package com.github.zipzoper.zoojava.util;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String line = sc.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m❌ Valor inválido! Digite um número inteiro.\u001B[0m");
            }
        }
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static String lerStringOpcao(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine().trim();
    }
}
