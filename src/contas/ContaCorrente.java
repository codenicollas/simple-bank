package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Operacao;

public class ContaCorrente extends ContaBancaria {

    private double limiteCredito;

    public ContaCorrente(Cliente cliente, double saldoInicial, double limiteCredito) {
        super(cliente, saldoInicial);
        this.limiteCredito = limiteCredito;
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

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}