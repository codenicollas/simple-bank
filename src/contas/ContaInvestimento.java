package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Data;

// mais uma que herda da conta base
public class ContaInvestimento extends ContaBancaria {

    // data em que o dinheiro fica liberado pra tirar ou que o rendimento cai???
    private Data vencimento;

    // repassa o básico pra classe mãe resolver e guarda a data do investimento aqui
    public ContaInvestimento(Cliente cliente, double saldo, Data vencimento) {
        super(cliente, saldo);
        this.vencimento = vencimento;
    }

    // FAÇA AS VERIFICAÇÕES AQUI
    // PS: a verificação que está aqui é a padrão, tem que alterar
    @Override
    protected boolean autorizaSaque(double valor) {
        return valor <= this.getSaldo();
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("");
    }

    public Data getVencimento() {
        return vencimento;
    }
}