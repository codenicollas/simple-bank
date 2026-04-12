package contas;

import base.ContaBancaria;
import modelos.Cliente;

// herda da conta base, mas com a regra de render juros em um dia específico
public class ContaPoupanca extends ContaBancaria {

    // dia do mês que a conta faz aniversário
    private int aniversario;

    // joga cliente e saldo pra classe mãe e salva o dia do aniversário aqui
    public ContaPoupanca(Cliente cliente, double saldo, int aniversario) {
        super(cliente, saldo);
        this.aniversario = aniversario;
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Poupança");
        System.out.println("  Aniversário: " + this.aniversario);
    }

    public int getAniversario() {
        return aniversario;
    }
}