package modelos;

public class Movimentacao {

    private int quantidade;
    private double valorTotal;

    public Movimentacao() {
        this.quantidade = 0;
        this.valorTotal = 0.0;
    }

    public void registrarOperacao(double valor) {
        this.quantidade++;
        this.valorTotal = this.valorTotal + valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }
}