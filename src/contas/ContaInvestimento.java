package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Data;
import modelos.Operacao;

public class ContaInvestimento extends ContaBancaria {

    private Data vencimento;

    public ContaInvestimento(Cliente cliente, double saldo, Data vencimento) {
        super(cliente, saldo);
        this.vencimento = vencimento;
    }

    @Override
    public void movimenta(Operacao operacao) {
        // lógica única

        // usa o comportamento padrão da ContaBancaria
        super.movimenta(operacao);
    }

    public Data getVencimento() {
        return vencimento;
    }
}