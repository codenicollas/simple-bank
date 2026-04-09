package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Operacao;

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

    // sobrescreve o método original pra gente poder injetar a regra do limite antes
    // de sacar
    @Override
    public void movimenta(Operacao operacao) {
        // lógica única (CRÉDITO)
        char tipo = operacao.getTipo();
        double valorOperacao = operacao.getValor();

        if (tipo == 'S'){
            if((getCredito() + this.credito) < valorOperacao){
                System.out.println("Saldo Insuficiente");
                return;
            }
        }
        // usa o comportamento padrão da ContaBancaria
        // chama o método da classe mãe pra fazer o trabalho pesado de atualizar o saldo
        super.movimenta(operacao);
        System.out.println("Opreação Realizada com Sucesso");
        System.out.println("Saldo atual: " + getCredito());
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("");
    }

    public double getCredito() {
        return credito;
    }

    public void setLimiteCredito(double credito) {
        this.credito = credito;
    }
}