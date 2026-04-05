package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Operacao;

public class ContaCorrente extends ContaBancaria {

    private double credito;

    public ContaCorrente(Cliente cliente, double saldo, double credito) {
        super(cliente, saldo);
        this.credito = credito;
    }

    @Override
    public void movimenta(Operacao operacao) {
        // lógica única 

        // usa o comportamento padrão da ContaBancaria
        super.movimenta(operacao);
    }

    @Override
    public void realizarDeposito(double valor) {
        // lógica única

        // usa o comportamento padrão da ContaBancaria
        super.realizarDeposito(valor);
    }

    @Override
    public void realizarSaque(double valor) {
        // lógica única

        // usa o comportamento padrão da ContaBancaria
        super.realizarSaque(valor);
    }

    public double getCredito() {
        return credito;
    }

    public void setLimiteCredito(double credito) {
        this.credito = credito;
    }
}