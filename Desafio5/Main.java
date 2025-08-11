package Desafio5;

public class Main {
    public static void main(String[] args) {

        ContaCorrente naruto = new ContaCorrente(700,"Naruto",TipoConta.CORRENTE);
        //Cria o objeto naruto com os atributos, saldo e o tipo da conta.
        ContaPoupanca kakashi = new ContaPoupanca(500, "Kakashi",TipoConta.POUPANÇA);
        //Cria o objeto kaksashi com os atributos, saldo e o tipo da conta.

        naruto.consultarSaldo();
        kakashi.consultarSaldo(); // Retorna o saldo atual de ambas as contas..
        naruto.transfere(100, kakashi, true); // realiza a transferência de naruto  para o kakashi e retorna o detalhe da transferencia
        kakashi.consultarSaldo();
        naruto.consultarSaldo(); // Retorna o saldo após o processo de ambas as contas.

    }
}
