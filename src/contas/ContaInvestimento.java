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

    // FAZER AQUI
    @Override
    public void movimenta(Operacao operacao) {
    }

    public Data getDtVencimento() {
        return dtVencimento;
    }
}