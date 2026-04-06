package base;

import modelos.Cliente;
import modelos.Operacao;

public class ContaBancaria {

    private Cliente cliente;
    private double saldo;

    // PENSAR NISSO DEPOIS (acho que é histórico / log)
    // private Movimentacao depositos;
    // private Movimentacao saques;
    // private Movimentacao juros;

    public ContaBancaria(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    // pega a operacao e joga pro metodo certo dependendo do tipo
    public void movimenta(Operacao operacao) {
        char tipo = operacao.getTipo();
        double valor = operacao.getValor();

        // impede de sacar ou depositar zero/negativo
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        switch (tipo) {
            case 'D':
                realizarDeposito(valor);
                break;
            case 'S':
                // VERIFICAO NA BASE
                if (valor > this.saldo) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    realizarSaque(valor);
                }
                break;
            default:
                System.out.println("Operação inválida.");
                break;
        }
    }

    // só adiciona o dinheiro no saldo
    public void realizarDeposito(double valor) {
        this.saldo = this.saldo + valor;
        System.out.println("Depósito realizado. O novo valor é: " + this.saldo);
    }

    // logica do caixa fisico dar as notas certas
    public void realizarSaque(double valor) {
        // Se o valor tiver centavos, barra
        if (valor % 1 != 0) {
            System.out.println("Valor inválido: Este caixa não opera moedas/centavos.");
            return;
        }

        // cast pra int porque não tem "moedas" no ATM
        int restante = (int) valor;

        int[] notas = { 100, 50, 20, 10, 5, 2 };
        String extratoNotas = "";

        // vai descendo o array do maior pro menor pra usar o minimo de notas possivel
        for (int nota : notas) {
            int quantidade = restante / nota;

            if (quantidade > 0) {
                extratoNotas += quantidade + " nota(s) de R$ " + nota + "\n";
                restante %= nota; // atualiza o restante só com o que sobrou
            }
        }

        // se fechou a conta certinha com as notas que temos
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