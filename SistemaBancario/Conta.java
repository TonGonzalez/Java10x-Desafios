package SistemaBancario;

public interface Conta {

        void consultarSaldo();
        void depositar(double valor);
        boolean sacar(double valor);
}

