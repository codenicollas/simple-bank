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
        System.out.println("  Tipo: Conta Investimento");
        System.out.println("  Vencimento: " + this.vencimento);
    }

    public Data getVencimento() {
        return vencimento;
    }

    @Override
    protected void aplicarJuros(double taxa) {
        // if (taxa <= 0) {
        // System.out.println("Taxa de juros inválida."); //validada na mãe?
        // return;}
        rendimentoJuros(taxa);

    }

    protected void rendimentoJuros(double taxa) {
        double saldoAntes = getSaldo();
        double rendimento = getSaldo() * (taxa / 100); // registra saldo previsto como juros
        realizarDeposito(rendimento); // atualiza saldo

        System.out.println("Rendimento aplicado: R$ " + rendimento);
        System.out.println("Saldo anterior: R$ " + saldoAntes);
    }

}