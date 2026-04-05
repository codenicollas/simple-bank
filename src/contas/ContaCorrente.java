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
        // lógica única (CRÉDITO)

        // usa o comportamento padrão da ContaBancaria
        super.movimenta(operacao);
    }

    public double getCredito() {
        return credito;
    }

    public void setLimiteCredito(double credito) {
        this.credito = credito;
    }
}