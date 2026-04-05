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

    public int getDiaAniversario() {
        return diaAniversario;
    }
}