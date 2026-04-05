package modelos;

public class ContaPoupanca extends ContaBancaria{
	private int diaAniversario;

	public ContaPoupanca (Cliente cliente, double saldoInicial, int diaAniversario){

		super( cliente, saldoInicial);
		this.diaAniversario = diaAniversario;
	}
	@Override
	public void movimenta (Operacao operacao){
		super.movimenta(operacao);
	}
}