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

    // FAZER AQUI
    @Override
    public void movimenta(Operacao operacao) {

    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}