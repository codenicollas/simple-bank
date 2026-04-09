package contas;

import base.ContaBancaria;
import modelos.Cliente;
import modelos.Operacao;

// herda da conta base, mas com a regra de render juros em um dia específico
public class ContaPoupanca extends ContaBancaria {

    // dia do mês que a conta faz aniversário
    private int aniversario;

    // joga cliente e saldo pra classe mãe e salva o dia do aniversário aqui
    public ContaPoupanca(Cliente cliente, double saldo, int aniversario) {
        super(cliente, saldo);
        this.aniversario = aniversario;
    }

    // sobrescreve pra poder aplicar a regra do rendimento antes de mexer no
    // dinheiro
    @Override
    public void movimenta(Operacao operacao) {
        // lógica única
        // (aqui entraria a checagem pra ver se é o dia certo de calcular os juros)

        // usa o comportamento padrão da ContaBancaria
        // repassa a operação de fato (saque/depósito) pra classe mãe resolver
        super.movimenta(operacao);
    }

    @Override
    protected void exibirDadosEspecificos() {
        System.out.println("");
    }

    public int getAniversario() {
        return aniversario;
    }
}