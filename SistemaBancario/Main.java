package SistemaBancario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContaCorrente[] contaC = new ContaCorrente[10];
        ContaPoupanca[] contaP = new ContaPoupanca[10];
        int opcaoMenu = 0;
        int qtdCorrentes = 0;
        int qtdPoupancas = 0;

        while (opcaoMenu != 8) {
            System.out.println("=== Bem-vindo ao Sistema Bancário ===");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Mostrar Saldo");
            System.out.println("6. Listar Nomes e tipo de conta");
            System.out.println("7. Listar todas informações");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu) {
                case 1:
                    System.out.println("Qual tipo de conta deseja criar:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta poupança");
                    System.out.print("Escolha uma opção: ");
                    String tipoConta = sc.nextLine();
                    if (tipoConta.equals("1")) {
                        if (qtdCorrentes >= 10) {
                            System.out.println("Excedeu o limite do cadastro!");
                        } else {
                            System.out.println("\n_____Cadastrando conta corrente_____\n");
                            System.out.println("Digite o seu nome:");
                            String nome = sc.nextLine();
                            ContaCorrente contaCorrente = new ContaCorrente(1000, nome);
                            contaC[qtdCorrentes] = contaCorrente;
                            qtdCorrentes++;
                        }
                    } else if (tipoConta.equals("2")) {
                        if (qtdPoupancas >= 10) {
                            System.out.println("Excedeu o limite do cadastro!");
                        } else {
                            System.out.println("\n_____Cadastrando conta poupança_____\n");
                            System.out.println("Digite seu nome:");
                            String nome = sc.nextLine();
                            ContaPoupanca contaPoupanca = new ContaPoupanca(1000, nome);
                            contaP[qtdPoupancas] = contaPoupanca;
                            qtdPoupancas++;
                        }
                    }
                 break;

                case 2:
                    System.out.println("\n===== Depositar =====");
                    System.out.println("\n");
                    System.out.println("Deseja depositar em:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    String tipoDep = sc.nextLine();
                    System.out.print("Digite o nome do titular da conta: ");
                    String buscaNome = sc.nextLine();
                    System.out.print("Digite o valor do depósito: ");
                    double valorDep = sc.nextDouble();
                    sc.nextLine();

                    boolean encontrado = false;

                    if (tipoDep.equals("1")) { // Corrente
                        for (int i = 0; i < qtdCorrentes; i++) {
                            if (contaC[i].getNome().equalsIgnoreCase(buscaNome)) {
                                contaC[i].depositar(valorDep);
                                encontrado = true;
                                break;
                            }
                        }
                    } else if (tipoDep.equals("2")) { // Poupança
                        for (int i = 0; i < qtdPoupancas; i++) {
                            if (contaP[i].getNome().equalsIgnoreCase(buscaNome)) {
                                contaP[i].depositar(valorDep);
                                encontrado = true;
                                break;
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 3:
                    System.out.println("\n===== Sacar =====");
                    System.out.println("\n");
                    System.out.println("Deseja sacar em:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    String tipoSaq = sc.nextLine();
                    System.out.print("Digite o nome do titular da conta: ");
                    String localizaNome = sc.nextLine();
                    System.out.print("Digite o valor do saque: ");
                    double valorSaq = sc.nextDouble();
                    sc.nextLine();

                    boolean achado = false;

                    if (tipoSaq.equals("1")) { // Corrente
                        for (int i = 0; i < qtdCorrentes; i++) {
                            if (contaC[i].getNome().equalsIgnoreCase(localizaNome)) {
                                contaC[i].sacar(valorSaq);
                                achado = true;
                                break;
                            }
                        }
                    } else if (tipoSaq.equals("2")) { // Poupança
                        for (int i = 0; i < qtdPoupancas; i++) {
                            if (contaP[i].getNome().equalsIgnoreCase(localizaNome)) {
                                contaP[i].sacar(valorSaq);
                                achado = true;
                                break;
                            }
                        }
                    }
                    if (!achado) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    System.out.println("\n===== Transferir =====\n");
                    System.out.println("Transferir de:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    String tipoTrans = sc.nextLine();

                    System.out.print("Digite o nome do titular da conta de origem: ");
                    String nomeTitular = sc.nextLine();
                    System.out.print("Digite o nome do titular da conta de destino: ");
                    String nomeRecebido = sc.nextLine();
                    System.out.print("Digite o valor da transferência: ");
                    double valorTrans = sc.nextDouble();
                    sc.nextLine();

                    ContaBancaria contaOrigem = null;
                    ContaBancaria contaDestino = null;

                    // localizar conta de origem
                    if (tipoTrans.equals("1")) { // Corrente
                        for (int i = 0; i < qtdCorrentes; i++) {
                            if (contaC[i].getNome().equalsIgnoreCase(nomeTitular)) {
                                contaOrigem = contaC[i];
                                break;
                            }
                        }
                    } else if (tipoTrans.equals("2")) { // Poupança
                        for (int i = 0; i < qtdPoupancas; i++) {
                            if (contaP[i].getNome().equalsIgnoreCase(nomeTitular)) {
                                contaOrigem = contaP[i];
                                break;
                            }
                        }
                    }

                    // localizar conta de destino (pode estar em corrente OU poupança)
                    for (int i = 0; i < qtdCorrentes; i++) {
                        if (contaC[i] != null && contaC[i].getNome().equalsIgnoreCase(nomeRecebido)) {
                            contaDestino = contaC[i];
                            break;
                        }
                    }
                    if (contaDestino == null) {
                        for (int i = 0; i < qtdPoupancas; i++) {
                            if (contaP[i] != null && contaP[i].getNome().equalsIgnoreCase(nomeRecebido)) {
                                contaDestino = contaP[i];
                                break;
                            }
                        }
                    }

                    // efetivar transferência
                    if (contaOrigem != null && contaDestino != null) {
                        contaOrigem.transfere(valorTrans, contaDestino, true);
                    } else {
                        System.out.println("Conta de origem ou destino não encontrada!");
                    }
                    break;

                case 5:
                    System.out.println("\n===== Saldo em Conta =====");
                    System.out.println("\n");
                    System.out.println("Deseja visualizar em:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    String visualConta = sc.nextLine();
                    System.out.print("Digite o nome do titular da conta: ");
                    String tituCont = sc.nextLine();
                    sc.nextLine();

                    boolean tituAchado = false;

                    if (visualConta.equals("1")) { // Corrente
                        for (int i = 0; i < qtdCorrentes; i++) {
                            if (contaC[i].getNome().equalsIgnoreCase(tituCont)) {
                                contaC[i].consultarSaldo();
                                tituAchado = true;
                                break;
                            }
                        }
                    }  else if (visualConta.equals("2")) { // Poupança
                        for (int i = 0; i < qtdPoupancas; i++) {
                            if (contaP[i].getNome().equalsIgnoreCase(tituCont)) {
                                contaP[i].consultarSaldo(); // faltava isso!
                                tituAchado = true;
                                break;
                            }
                        }
                    }
                    if (!tituAchado) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 6:
                    System.out.println("\n==== Lista de Nomes ====\n");
                    System.out.println("\n_____Conta Corrente:_____\n");
                    for (int i = 0; i < qtdCorrentes; i++) {
                        System.out.println(contaC[i].getNome());
                    }
                    System.out.println("\n_____Conta Poupança:_____\n");
                    for (int i = 0; i < qtdPoupancas; i++) {
                        System.out.println(contaP[i].getNome());
                    }
                    break;

                case 7:
                    System.out.println("\n==== Lista de Nomes e Saldo em conta ====\n");
                    System.out.println("\n_____Conta Corrente:_____\n");
                    for (int i = 0; i < qtdCorrentes; i++) {
                        System.out.println("Nome: "+contaC[i].getNome());
                        System.out.println("Saldo: R$"+contaC[i].getSaldo());
                    }
                    System.out.println("\n_____Conta Poupança:_____\n");
                    for (int i = 0; i < qtdPoupancas; i++) {
                        System.out.println("Nome: "+contaP[i].getNome());
                        System.out.println("Saldo: R$"+contaP[i].getSaldo());
                    }
                    break;

            }
        }
        sc.close();

    }
}