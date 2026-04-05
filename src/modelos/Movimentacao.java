package modelos;

public class Movimentacao {

    private int quantidade;
    private double valorTotal;

    public Movimentacao(int quantidade, double valorTotal) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public void registrarOperacao(double valor) {
        this.quantidade++;
        this.valorTotal = this.valorTotal + valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}