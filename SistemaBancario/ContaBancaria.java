package SistemaBancario;

public abstract class ContaBancaria implements Conta{

    protected double saldo;
    private String nome;

    public final double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaBancaria(double saldo, String nome){
        this.saldo = saldo;
        this.nome = nome;
    }

    protected void adicionarSaldo(double valor) {
        this.saldo += valor;
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Seu saldo é de: "+ saldo);
    }

    @Override
    public abstract void depositar(double valor);

    public boolean sacar(double valor){
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
        if (this.sacar(valor)) {
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
