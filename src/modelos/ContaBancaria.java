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

        if (tipo == 'D' || tipo == 'd') {
            System.out.println("DEPOSITO");
        } else {
            System.out.println("SAQUE");
        }
    }
}