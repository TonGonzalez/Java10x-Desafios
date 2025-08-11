package Desafio5;

public abstract class ContaBancaria implements Conta{

    double saldo;
    String nome; //variaveis para o método construtor

    public ContaBancaria(double saldo, String nome){
        this.saldo = saldo;
        this.nome = nome; //método construtor para criar o objeto
    }


    @Override
    public void consultarSaldo(){
        System.out.println("Seu saldo é de: "+ saldo);
    } //método para consultar o saldo do objeto

    @Override
    public abstract void depositar(double valor); // método abstrato para ser usado de forma diferente nas classes filhas

    public boolean sacar(double valor){ // método sacar em boolean para fazer acontecer a transferencia de um objeto para o outro
        if (saldo >= valor){
            saldo -= valor;
            System.out.println("Saque efetuado, saldo atual: R$"+saldo);
            return true;
        }else {
            System.out.println("Saldo insuficiente, seu saldo: R$"+saldo+" valor do saque desejado: R$"+valor);
            return false;
        }
    }

    public boolean transfere(double valor , ContaBancaria destino) {
        if (this.sacar(valor)) { // se o método sacar for true, vai retornar o saque para o objeto desejado, declarado como "destino"
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, ContaBancaria destino, boolean mostrarDetalhes) { //método sobrecarregado e agora trás informação detalhada da transferencia realizada.
        boolean sucesso = transfere(valor, destino);
        if (mostrarDetalhes) {
            if (sucesso) {
                System.out.println("Transferência de R$"+valor+" para: "+destino.nome+" realizada com sucesso.");
            } else {
                System.out.println("Falha na transferência.");
            }
        }
        return sucesso;
    }


}
