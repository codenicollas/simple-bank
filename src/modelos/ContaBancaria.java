package modelos;

public class ContaBancaria {

    private Cliente cliente;
    private double saldoInicial;

    private Movimentacao depositos;
    private Movimentacao saques;
    private Movimentacao juros;

    public ContaBancaria(Cliente cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldoInicial = saldoInicial;
    }

    public void movimenta(Operacao operacao) {
        char tipo = operacao.getTipo();
        double valor = operacao.getValor();

        if (tipo == 'D') {
            this.saldoInicial = this.saldoInicial + valor;
            System.out.println("Depósito realizado. O novo valor é: " + this.saldoInicial);
        } else {
            if (this.saldoInicial < valor) {
                System.out.println("Saldo insuficiente");
                return;
            }

            this.saldoInicial = this.saldoInicial - valor;
            System.out.println("Saque realizado. O novo valor é: " + this.saldoInicial);
        }
    }
}