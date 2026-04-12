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

    @Override
    public void movimenta(Operacao operacao) {
        if (operacao.getTipo() == 'S') {
            System.out.println("Esse tipo de conta não pode fazer saques.");
            return;
        }

        super.movimenta(operacao);
    }

    @Override
    public void realizarSaque(double valor) {
        System.out.println("Esse tipo de conta não pode realizar saque");
        return;
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Investimento");
        System.out.println("  Vencimento: " + this.vencimento);
    }

    public Data getVencimento() {
        return vencimento;
    }
}