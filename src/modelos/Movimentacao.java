package modelos;

import java.util.Date;

public class Movimentacao {
    
    private int quantidade;
    private double valorTotal;

    public Movimentacao(int quantidade, double valorTotal) {
            this.quantidade = quantidade;
            this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade() {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setvalorTotal() {
        this.valorTotal = valorTotal;
    }

}
