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

    // FAÇA AS VERIFICAÇÕES AQUI
    // PS: a verificação que está aqui é a padrão, tem que alterar
    @Override
    protected boolean autorizaSaque(double valor) {
        return valor <= this.getSaldo();
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Poupança");
        System.out.println("  Aniversário: " + this.aniversario);
    }

    public int getAniversario() {
        return aniversario;
    }

    @Override
    protected void aplicarJuros(double taxa) {
 
        rendimentoJuros(taxa);

    }

protected void rendimentoJuros(double taxa) {
        double saldoAntes = getSaldo();
        double rendimento = getSaldo() * (taxa / 100); 
        realizarDeposito(rendimento); 

        System.out.println("Rendimento aplicado: R$ " + rendimento);
        System.out.println("Saldo anterior: R$ " + saldoAntes);
    }
}