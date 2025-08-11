package Desafio5;

public class ContaCorrente extends ContaBancaria {

    double valor;
    TipoConta tipoConta;

    public ContaCorrente(double saldo, String nome, TipoConta tipoConta) {
        super(saldo, nome);
        this.tipoConta = TipoConta.CORRENTE;
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo atual é de: " + saldo);
    }

    @Override
    public void depositar(double valor) { // método usado agora na classe "Conta corrente" fazendo com que o valor atualize conforme o saldo depositado.
        this.valor = valor;
        saldo += this.valor;
        System.out.println("Saldo atual com o deposíto é de:" + saldo);
    }
}
