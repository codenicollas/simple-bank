package base;

import modelos.Cliente;
import modelos.Operacao;

public class ContaBancaria {

    private Cliente cliente;
    private double saldo;

    // PENSAR NISSO DEPOIS
    // private Movimentacao depositos;
    // private Movimentacao saques;
    // private Movimentacao juros;

    public ContaBancaria(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void movimenta(Operacao operacao) {
        char tipo = operacao.getTipo();
        double valor = operacao.getValor();

        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        switch (tipo) {
            case 'D':
                realizarDeposito(valor);
                break;
            case 'S':
                realizarSaque(valor);
                break;
            default:
                break;
        }
    }

    public void realizarDeposito(double valor) {
        this.saldo = this.saldo + valor;
        System.out.println("Depósito realizado. O novo valor é: " + this.saldo);
    }

    public void realizarSaque(double valor) {

        // Se o valor tiver centavos, barra
        if (valor % 1 != 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        // cast pra int porque não tem "moedas" no ATM
        int restante = (int) valor;

        int[] notas = { 100, 50, 20, 10, 5, 2 };
        String extratoNotas = "";

        for (int nota : notas) {
            int quantidade = restante / nota;

            if (quantidade > 0) {
                extratoNotas += quantidade + " nota(s) de R$ " + nota + "\n";
                restante %= nota;
            }
        }

        if (restante == 0) {
            this.saldo -= valor;

            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            System.out.print(extratoNotas);
            System.out.println("Novo saldo: R$ " + this.saldo);
        } else {
            System.out.println("Erro: Não é possível sacar R$ " + valor + " com as notas disponíveis.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}