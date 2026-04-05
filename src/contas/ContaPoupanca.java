package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Operacao;

public class ContaPoupanca extends ContaBancaria {

    private int diaAniversario;

    public ContaPoupanca(Cliente cliente, double saldoInicial, int diaAniversario) {
        super(cliente, saldoInicial);
        this.diaAniversario = diaAniversario;
    }

    // FAZER AQUI
    @Override
    public void movimenta(Operacao operacao) {
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }
}