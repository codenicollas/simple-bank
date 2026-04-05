package base;

import modelos.Cliente;
import modelos.Operacao;

public class ContaBancaria {

    private Cliente cliente;
    private double saldo;

    // PENSAR NISSO DEPOIS
    // private Movimentacao depositos;
    // private Movimentacao saques;
    // private Movimentacao juros;

    public ContaBancaria(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void movimenta(Operacao operacao) {
        char tipo = operacao.getTipo();
        double valor = operacao.getValor();

        if (tipo == 'D') {
            this.saldo = this.saldo + valor;
            System.out.println("Depósito realizado. O novo valor é: " + this.saldo);
        } else {
            if (this.saldo < valor) {
                System.out.println("Saldo insuficiente");
                return;
            }

            this.saldo = this.saldo - valor;
            System.out.println("Saque realizado. O novo valor é: " + this.saldo);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}