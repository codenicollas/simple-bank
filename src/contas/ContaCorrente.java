package contas;

import base.ContaBancaria;
import modelos.Cliente;

// herda de ContaBancaria, ou seja, tem tudo que a outra tem mais algumas coisas novas
public class ContaCorrente extends ContaBancaria {

    // crédito extra que o cliente tem além do saldo (tipo um cheque especial)
    private double credito;

    // o super joga o cliente e o saldo pra classe mãe resolver, e a gente só guarda
    // o crédito aqui
    public ContaCorrente(Cliente cliente, double saldo, double credito) {
        super(cliente, saldo);
        this.credito = credito;
    }

    // FAÇA AS VERIFICAÇÕES AQUI
    // PS: a verificação que está aqui é a padrão, tem que alterar

    @Override
    public void aplicarJuros(double taxa) {
        System.out.println("Não permitido para Conta Corrente");
        return;
    }

    @Override
    protected boolean autorizaSaque(double valor) {
        return valor <= (getSaldo() + this.credito);
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("Crédito: " + this.credito);
    }

    public double getCredito() {
        return credito;
    }

    public void setLimiteCredito(double credito) {
        this.credito = credito;
    }
}