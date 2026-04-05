package modelos;

public class ContaInvestimento extends ContaBancaria {
    
    private Data dtVencimento;

    public ContaInvestimento(Cliente cliente, double saldoInicial, Data dtVencimento) {
        super(cliente, saldoInicial);
        this.dtVencimento = dtVencimento;
    }

    @Override
    public void movimenta(Operacao operacao) {
        super.movimenta(operacao);
    }
}