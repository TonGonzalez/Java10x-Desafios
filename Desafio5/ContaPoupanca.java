package Desafio5;

public class ContaPoupanca extends ContaBancaria{

    TipoConta tipoConta;
    double valor;

    public ContaPoupanca(double saldo, String nome , TipoConta tipoConta){
        super(saldo, nome);
        this.tipoConta = TipoConta.POUPANÇA;
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Seu saldo atual é de: "+saldo);
    }

    @Override
    public void depositar(double valor){ // método usado agora na classe "Conta poupança" fazendo com que o valor atualize conforme o saldo depositado, sofrendo um desconto de 6%.
        this.valor = valor - (valor*0.06);
        saldo += this.valor;
        System.out.println("Saldo atual com o deposíto é de:" + saldo);
    }


}
