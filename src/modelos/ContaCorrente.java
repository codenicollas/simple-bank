package modelos;

public class ContaCorrente extends ContaBancaria{

    private double limiteCredito;

    public void movimentaLimiteCredito(double limiteCredito){
        // A ESCREVER
    }

    public ContaCorrente(Cliente cliente, double saldoInicial, double limiteCredito) {
        super(cliente, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

}