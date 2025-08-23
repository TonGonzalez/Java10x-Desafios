package SistemaBancario;

public class ContaPoupanca extends ContaBancaria{

    TipoConta tipoConta;

    public ContaPoupanca(double saldo, String nome) {
        super(saldo, nome);
        this.tipoConta = TipoConta.POUPANÇA;
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo atual é de: " + getSaldo());
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        double valorComDesconto = valor - (valor * 0.06); // desconto de 6%
        adicionarSaldo(valorComDesconto); // reaproveita método da mãe
        System.out.println("Depósito realizado (com desconto de 6%). Saldo atual: " + getSaldo());
    }

}

