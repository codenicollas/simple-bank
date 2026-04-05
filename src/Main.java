import java.util.Scanner;

import modelos.Cliente;
import modelos.ContaCorrente;
import modelos.Data;
import modelos.Operacao;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Bem-vindo ao Aplicativo Bancário ===");
            System.out.println("Menu de opções:");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Mostrar integrantes do grupo");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("\n--- Abertura de Conta ---");
                    System.out.println("Qual tipo de conta você deseja abrir?");
                    System.out.println("C - Corrente\nP - Poupança\nI - Investimento");
                    System.out.print("Sua escolha: ");

                    char tipoConta;

                    while (true) {
                        System.out.println("Qual tipo de conta você deseja abrir?");
                        System.out.println("C - Corrente\nP - Poupança\nI - Investimento");
                        System.out.print("Sua escolha: ");

                        tipoConta = scanner.next().toUpperCase().charAt(0);
                        if (tipoConta == 'C' || tipoConta == 'P' || tipoConta == 'I') {
                            break;
                        }

                        System.out.println("\nTipo de conta inválido. Tente novamente.\n");
                    }

                    Cliente cliente = pedirDados(scanner);

                    switch (tipoConta) {
                        case 'C':
                            System.out.println("\n>>> Conta Corrente criada com sucesso! <<<");
                            ContaCorrente contaCorrente = new ContaCorrente(cliente, 1000, 0);

                            scanner.nextLine();

                            System.out.print("Qual o tipo da operação? (D para depósito, S para saque): ");
                            String tipoOperacao = scanner.nextLine().toUpperCase();

                            System.out.print("Insira o valor da operação: R$ ");
                            double valor = scanner.nextDouble();

                            Operacao operacao = new Operacao(tipoOperacao.charAt(0), valor);
                            contaCorrente.movimenta(operacao);

                            System.out.println("Operação realizada com sucesso!");
                            break;
                        case 'P':
                            System.out.println("\n>>> Conta Poupança criada com sucesso! <<<");
                            break;
                        case 'I':
                            System.out.println("\n>>> Conta Investimento criada com sucesso! <<<");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("\n--- Integrantes do grupo ---");
                    System.out.println("* Nicolas Pinheiro Bueno");
                    System.out.println("* Guilherme Jefinny Souto");
                    System.out.println("* João Tietbohl");
                    System.out.println("* Enzo Bueno");
                    break;
                case 3:
                    rodando = false;
                    System.out.println("\nPrograma finalizado.");
                    break;
                default:
                    System.out.println("\nEscolha inválida. Escolha novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static Cliente pedirDados(Scanner scanner) {
        scanner.nextLine();

        System.out.println("\n--- Dados do Cliente ---");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite seu dia de nascimento: ");
        int dia = scanner.nextInt();

        System.out.print("Digite o seu mês de nascimento: ");
        int mes = scanner.nextInt();

        System.out.print("Digite seu ano de nascimento: ");
        int ano = scanner.nextInt();

        Data data = new Data(dia, mes, ano);

        return new Cliente(nome, cpf, data);
    }

    private static boolean verificarNumero(String valorStr) {
        try {
            double valor = Double.parseDouble(valorStr.trim());
            return valor > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}