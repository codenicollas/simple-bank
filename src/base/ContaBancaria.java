package base;

import modelos.Cliente;
import modelos.Movimentacao;
import modelos.Operacao;

public class ContaBancaria {

    private Cliente cliente;
    private double saldo;
    private double saldoInicial;

    private double saldoMinimo;
    private double saldoMaximo;

    private Movimentacao depositos;
    private Movimentacao saques;
    private Movimentacao juros;

    public ContaBancaria(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldoInicial = saldo;
        this.saldo = saldo;

        this.saldoMinimo = saldo;
        this.saldoMaximo = saldo;

        this.depositos = new Movimentacao();
        this.saques = new Movimentacao();
        this.juros = new Movimentacao();
    }

    // METODO PRINCIPAL
    // preferencialmente subscrever (Override) apenas esse metodo para
    // verificar as condições de cada conta

    // faz verificações básicas e apenas chama os metodos de deposito e saque
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
                if (!autorizaSaque(valor)) {
                    System.out.println("Saldo insuficiente.");
                    return;
                }

                realizarSaque(valor);
                break;
            case 'J':
                aplicarJuros(valor); // valida o valor nos param. de juros
                break;

            default:
                System.out.println("Operação inválida.");
                break;
        }
    }

    public void aplicarJuros(double taxa) {
        if (taxa <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        double saldoAntes = this.saldo;

        double rendimento = this.saldo * (taxa / 100);
        this.saldo += rendimento;

        this.juros.registrarOperacao(rendimento);

        if (this.saldo > this.saldoMaximo) {
            this.saldoMaximo = this.saldo;
        }

        System.out.println("Saldo anterior: R$ " + saldoAntes);
        System.out.println("Rendimento aplicado: R$ " + rendimento);
        System.out.println("Novo saldo: R$ " + this.saldo);
    }

    // só adiciona o dinheiro no saldo
    public void realizarDeposito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        this.saldo = this.saldo + valor;

        this.depositos.registrarOperacao(valor);

        if (this.saldo > this.saldoMaximo) {
            this.saldoMaximo = this.saldo;
        }

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

            this.saques.registrarOperacao(valor);

            if (this.saldo < this.saldoMinimo) {
                this.saldoMinimo = this.saldo;
            }

            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            System.out.print(extratoNotas);
            System.out.println("Novo saldo: R$ " + this.saldo);
        } else {
            System.out.println("Erro: Não é possível sacar R$ " + valor + " com as notas disponíveis.");
        }
    }

    // metodo para exibir extrato
    public void exibirExtrato() {
        System.out.println("\nEXTRATO BANCÁRIO");

        System.out.println("Cliente:    " + this.cliente.getNome());
        System.out.println("CPF:        " + this.cliente.getCpf());
        System.out.println("Nascimento: " + this.cliente.getDtNascimento());

        System.out.println("\nDados Específicos da Conta:");
        this.exibirDadosEspecificos();

        System.out.println("\nSaldos:");
        System.out.println("  Inicial: R$ " + this.saldoInicial);
        System.out.println("  Atual:   R$ " + this.saldo);

        System.out.println("\nMovimentações (Qtd - Valor Total):");
        System.out.println("  Depósitos: " + this.depositos.getQuantidade() + "  - R$ " + this.depositos.getValorTotal());
        System.out.println("  Saques:    " + this.saques.getQuantidade() + "  - R$ " + this.saques.getValorTotal());
        System.out.println("  Juros:     " + this.juros.getQuantidade() + "  - R$ " + this.juros.getValorTotal());

        System.out.println("\nPicos da Conta:");
        System.out.println("  Mínimo: R$ " + this.saldoMinimo);
        System.out.println("  Máximo: R$ " + this.saldoMaximo + "\n");
    }

    protected boolean autorizaSaque(double valor) {
        return valor <= this.saldo;
    }

    protected void exibirDadosEspecificos() {
        System.out.println("  Tipo: Conta Padrão");
    }

    public double getSaldo() {
        return this.saldo;
    }
}