package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Data;
import modelos.Operacao;

public class ContaInvestimento extends ContaBancaria {

    private Data dtVencimento;

    public ContaInvestimento(Cliente cliente, double saldoInicial, Data dtVencimento) {
        super(cliente, saldoInicial);
        this.dtVencimento = dtVencimento;
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

    public Data getDtVencimento() {
        return dtVencimento;
    }
}