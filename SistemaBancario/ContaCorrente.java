package SistemaBancario;

public class ContaCorrente extends ContaBancaria {

    double valor;
    TipoConta tipoConta;

    public ContaCorrente(double saldo, String nome) {
        super(saldo, nome);
        this.tipoConta = TipoConta.CORRENTE;
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
        adicionarSaldo(valor); // usa o método protegido da classe mãe
        System.out.println("Depósito realizado. Saldo atual: " + getSaldo());
    }
}