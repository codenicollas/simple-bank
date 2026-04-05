package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Operacao;

public class ContaPoupanca extends ContaBancaria {

    private int aniversario;

    public ContaPoupanca(Cliente cliente, double saldo, int aniversario) {
        super(cliente, saldo);
        this.aniversario = aniversario;
    }

    @Override
    public void movimenta(Operacao operacao) {
        // lógica única

        // usa o comportamento padrão da ContaBancaria
        super.movimenta(operacao);
    }

    public int getAniversario() {
        return aniversario;
    }
}