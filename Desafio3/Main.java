package Desafio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Ninja[] ninjaComum = new Ninja[10];
        Uchiha[] ninjaUchiha = new Uchiha[10];
        int opcaoMenu = 0;
        int qtdComum = 0;
        int qtdUchiha = 0;

        while (opcaoMenu != 5) {
            System.out.println("\n===== Menu Ninja =====");
            System.out.println("1. Cadastrar Ninja");
            System.out.println("2. Atualizar Habilidade Uchiha");
            System.out.println("3. Listar nome dos Ninjas");
            System.out.println("4. Listar Ninjas e suas informações");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcaoMenu = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número entre 1 e 4.");
                scanner.nextLine();
                continue;
            }

            switch (opcaoMenu) {
                case 1:
                    System.out.println("Qual tipo de Ninja deseja cadastrar:");
                    System.out.println("1. Ninja Comum");
                    System.out.println("2. Ninja Uchiha");
                    System.out.print("Escolha uma opção: ");
                    String tipoNinja = scanner.nextLine();
                    if (tipoNinja.equals("1")) {
                        if (qtdComum >= 10) {
                            System.out.println("Excedeu o limite do cadastro!");
                        } else {
                            Ninja ninja = new Ninja();
                            System.out.println("\n_____Cadastrando um novo ninja comum_____\n");
                            System.out.println("Digite o nome do ninja:");
                            ninja.nome = scanner.nextLine();
                            System.out.println("Digite a idade do Ninja");
                            ninja.idade = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite a missão do Ninja");
                            ninja.missao = scanner.nextLine();
                            System.out.println("Digite o status da missão do Ninja");
                            ninja.statusMissao = scanner.nextLine();
                            ninjaComum[qtdComum] = ninja;
                            qtdComum++;
                        }
                    } else if (tipoNinja.equals("2")) {
                        if (qtdUchiha >= 10) {
                            System.out.println("Excedeu o limite do cadastro!");
                        } else {
                            Uchiha uchiha = new Uchiha();
                            System.out.println("\n_____Cadastrando um novo ninja Uchiha_____\n");
                            System.out.println("Digite o nome do ninja Uchiha:");
                            uchiha.nome = scanner.nextLine();
                            System.out.println("Digite a idade do Ninja Uchiha:");
                            uchiha.idade = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite a missão do Ninja Uchiha:");
                            uchiha.missao = scanner.nextLine();
                            System.out.println("Digite o status da missão do Ninja Uchiha:");
                            uchiha.statusMissao = scanner.nextLine();
                            System.out.println("Digite a habilidade do seu Uchiha:");
                            uchiha.habilidadeEspecial = scanner.nextLine();
                            ninjaUchiha[qtdUchiha] = uchiha;
                            qtdUchiha++;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n===== Atualizar Habilidade Especial do Uchiha =====");
                    System.out.print("Digite o nome do Uchiha que deseja atualizar: ");
                    String buscaNinja = scanner.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < qtdUchiha; i++) {
                        if (ninjaUchiha[i].nome.equalsIgnoreCase(buscaNinja)) {
                            System.out.println("Habilidade atual: " + ninjaUchiha[i].habilidadeEspecial);
                            System.out.print("Digite a nova habilidade especial: ");
                            ninjaUchiha[i].habilidadeEspecial = scanner.nextLine();
                            System.out.println("Habilidade atualizada com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Uchiha com nome \"" + buscaNinja + "\" não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("\n_____Lista de ninjas_____\n");
                    System.out.println("\n_____Ninjas Comuns:_____\n");
                    for (int i = 0; i < qtdComum; i++) {
                        System.out.println(ninjaComum[i].nome);
                    }
                    System.out.println("\n_____Ninjas Uchihas:_____\n");
                    for (int i = 0; i < qtdUchiha; i++) {
                        System.out.println(ninjaUchiha[i].nome);
                    }
                    break;
                case 4:
                    System.out.println("\n_____Lista de informações ninjas_____\n");
                    System.out.println("\n_____Ninjas Comuns:_____\n");
                    for (int i = 0; i < qtdComum; i++) {
                        System.out.println(ninjaComum[i]);
                    }
                    System.out.println("\n_____Ninjas Uchihas:_____\n");
                    for (int i = 0; i < qtdUchiha; i++) {
                        System.out.println(ninjaUchiha[i]);
                    }
                    break;
                case 5:
                    System.out.println("Saindo da tela...");
                    break;
                default:
                    System.out.println("Entrada inválida! Por favor, digite um número entre 1 e 3.");
            }
        }
        scanner.close();
    }
}





