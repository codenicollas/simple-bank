package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Data;
import modelos.Operacao;

// mais uma que herda da conta base
public class ContaInvestimento extends ContaBancaria {

    // data em que o dinheiro fica liberado pra tirar ou que o rendimento cai???
    private Data vencimento;

    // repassa o básico pra classe mãe resolver e guarda a data do investimento aqui
    public ContaInvestimento(Cliente cliente, double saldo, Data vencimento) {
        super(cliente, saldo);
        this.vencimento = vencimento;
    }

    // sobrescreve com regras únicas
    @Override
    public void movimenta(Operacao operacao) {
        // lógica única

        // usa o comportamento padrão da ContaBancaria
        // se passou na nossa regra (não entendi qual), deixa a classe mãe mexer no
        // saldo
        super.movimenta(operacao);
    }

    public Data getVencimento() {
        return vencimento;
    }
}