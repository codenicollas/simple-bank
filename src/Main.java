import java.util.Scanner;

import contas.ContaCorrente;
import modelos.Cliente;
import modelos.Data;
import modelos.Operacao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;

        while (rodando) {
            System.out.println("\nMenu:");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Mostrar integrantes");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("\nAbertura de conta.");

                    char tipoConta;
                    while (true) {
                        System.out.print("Tipo (C - Corrente, P - Poupança, I - Investimento): ");
                        tipoConta = scanner.next().toUpperCase().charAt(0);

                        if (tipoConta == 'C' || tipoConta == 'P' || tipoConta == 'I') {
                            break;
                        }

                        System.out.println("Tipo inválido.");
                    }

                    Cliente cliente = pedirDados(scanner);

                    scanner.nextLine();

                    double saldoInicial;
                    while (true) {
                        System.out.print("Saldo inicial: ");
                        String saldoStr = scanner.nextLine();

                        if (verificarNumero(saldoStr)) {
                            saldoInicial = Double.parseDouble(saldoStr.trim());
                            break;
                        }

                        System.out.println("Valor numérico inválido.");
                    }

                    char tipoOperacao;
                    double valor;

                    switch (tipoConta) {
                        case 'C':
                            System.out.println("Conta Corrente selecionada.");

                            double limiteCredito;
                            while (true) {
                                System.out.print("Limite de crédito: ");
                                String limiteStr = scanner.nextLine();

                                if (verificarNumero(limiteStr)) {
                                    limiteCredito = Double.parseDouble(limiteStr.trim());
                                    break;
                                }

                                System.out.println("Valor numérico inválido.");
                            }

                            ContaCorrente contaCorrente = new ContaCorrente(cliente, saldoInicial, limiteCredito);
                            System.out.println("Conta Corrente instanciada.");

                            while (true) {
                                System.out.print("Operação (D - Depósito, S - Saque): ");
                                String entradaOp = scanner.nextLine();

                                if (verificarTipoOperacao(entradaOp)) {
                                    tipoOperacao = entradaOp.toUpperCase().trim().charAt(0);
                                    break;
                                }

                                System.out.println("Operação inválida.");
                            }

                            while (true) {
                                System.out.print("Valor da operação: ");
                                String valorStr = scanner.nextLine();

                                if (verificarNumero(valorStr)) {
                                    valor = Double.parseDouble(valorStr.trim());
                                    break;
                                }

                                System.out.println("Valor numérico inválido.");
                            }

                            Operacao operacao = new Operacao(tipoOperacao, valor);
                            contaCorrente.movimenta(operacao);

                            System.out.println("Sucesso.");
                            break;

                        case 'P':
                            System.out.println("Conta Poupança selecionada (Teste).");
                            break;

                        case 'I':
                            System.out.println("Conta Investimento selecionada (Teste).");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nIntegrantes:");
                    System.out.println("- Nicolas Pinheiro Bueno");
                    System.out.println("- Guilherme Jefinny Souto");
                    System.out.println("- João Tietbohl");
                    System.out.println("- Enzo Bueno");
                    break;

                case 3:
                    rodando = false;
                    System.out.println("Encerrando.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // STATIC POIS MAIN É STATIC
    private static Cliente pedirDados(Scanner scanner) {
        scanner.nextLine();

        System.out.println("\nDados do cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Dia nascimento: ");
        int dia = scanner.nextInt();

        System.out.print("Mês nascimento: ");
        int mes = scanner.nextInt();

        System.out.print("Ano nascimento: ");
        int ano = scanner.nextInt();

        Data data = new Data(dia, mes, ano);

        return new Cliente(nome, cpf, data);
    }

    // STATIC POIS MAIN É STATIC
    private static boolean verificarTipoOperacao(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return false;
        }

        char tipo = entrada.toUpperCase().trim().charAt(0);

        return tipo == 'D' || tipo == 'S';
    }

    // STATIC POIS MAIN É STATIC
    private static boolean verificarNumero(String valorStr) {
        try {
            double valor = Double.parseDouble(valorStr.trim());
            return valor > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}