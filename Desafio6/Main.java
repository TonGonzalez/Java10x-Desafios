package Desafio6;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InfoNinja ninja1 = new InfoNinja("Konoha", 18, "Naruto");
        InfoNinja ninja2 = new InfoNinja("Konoha", 19, "Sasuke");
        InfoNinja ninja3 = new InfoNinja("Konoha", 19, "Sakura");
        InfoNinja ninja4 = new InfoNinja("Konoha", 19, "Choji");
        InfoNinja ninja5 = new InfoNinja("Konoha", 19, "Shikamaru");
        InfoNinja ninja6 = new InfoNinja("Konoha", 18, "Rock Lee");
        InfoNinja ninja7 = new InfoNinja("Sunagakure", 19, "Gaara");

        LinkedList<InfoNinja> listaNinja = new LinkedList<>();

        listaNinja.add(ninja1);
        listaNinja.add(ninja2);
        listaNinja.add(ninja3);
        listaNinja.add(ninja4);
        listaNinja.add(ninja5);
        listaNinja.add(ninja6);
        listaNinja.add(ninja7);

        int control = 0;

        while (control != 6) {

            System.out.println("1. Exibir lista de ninjas");
            System.out.println("2. Remover primeiro Ninja");
            System.out.println("3. Adicionar novo Ninja no topo");
            System.out.println("4. Acessar informação do Ninja");
            System.out.println("5. Organizar ninjas");
            System.out.println("6. Sair");
            int value = sc.nextInt();
            sc.nextLine();

            switch (value) {
                case 1: {
                    System.out.println(listaNinja);
                    break;
                }

                case 2: {
                    System.out.println("===== Removendo o Ninja do topo =====");
                    if (!listaNinja.isEmpty()) {
                        System.out.println("Ninja: " + listaNinja.remove(0) + " Removido");
                    } else {
                        System.out.println("Lista vazia!");
                    }
                    break;
                }

                case 3: {
                    System.out.println("===== Criando um novo Ninja =====");
                    System.out.println("Digite o nome do ninja:");
                    String nome = sc.nextLine();
                    System.out.println("Digite a vila do ninja:");
                    String vila = sc.nextLine();
                    System.out.println("Digite a idade do ninja:");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    InfoNinja ninja = new InfoNinja(vila, idade, nome);
                    listaNinja.add(0, ninja);
                    break;
                }

                case 4: {
                    System.out.println("===== Verificar informações do Ninja =====");
                    System.out.println("Digite o nome do ninja que deseja verificar:");
                    String buscaNome = sc.nextLine();

                    boolean encontrado = false;
                    for (int i = 0; i < listaNinja.size(); i++) {
                        if (listaNinja.get(i).getNome().equalsIgnoreCase(buscaNome)) {
                            System.out.println(listaNinja.get(i));
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Ninja não localizado!");
                    }
                    break;
                }

                case 5: {
                    System.out.println("===== Organização Ninja, deseja organizar como? =====");
                    System.out.println("1 - Por nome");
                    System.out.println("2 - Por idade decrescente");
                    System.out.println("3 - Por idade crescente");
                    System.out.println("4 - Por vila");

                    int orderOption = sc.nextInt();
                    sc.nextLine();

                    switch (orderOption) {
                        case 1: {
                            listaNinja.sort(Comparator.comparing(InfoNinja::getNome));
                            System.out.println(listaNinja);
                            break;
                        }
                        case 2: {
                            listaNinja.sort(Comparator.comparing(InfoNinja::getIdade).reversed());
                            System.out.println(listaNinja);
                            break;
                        }
                        case 3: {
                            listaNinja.sort(Comparator.comparing(InfoNinja::getIdade));
                            System.out.println(listaNinja);
                            break;
                        }
                        case 4: {
                            listaNinja.sort(Comparator.comparing(InfoNinja::getVila));
                            System.out.println(listaNinja);
                            break;
                        }
                        default: {
                            System.out.println("Opção inválida!");
                            break;
                        }
                    }
                    break;
                }

                case 6: {
                    System.out.println("Saindo do programa...");
                    control = 6;
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        }

        sc.close();
    }
}
