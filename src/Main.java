import java.util.Scanner;

import base.ContaBancaria;
import contas.ContaCorrente;
import contas.ContaInvestimento;
import modelos.Cliente;
import modelos.Data;
import modelos.Operacao;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // flag pra manter o menu em loop até o usuário decidir sair
        boolean rodando = true;

        while (rodando) {
            exibirMenu();

            int escolha = scanner.nextInt();

            // limpa a quebra de linha que sobra no scanner pra não pular o próximo input
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    abrirConta(scanner);
                    break;
                case 2:
                    mostrarIntegrantes();
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

        // fechar scanner pro vscode não reclamar
        scanner.close();
    }

    // STATIC POIS MAIN É STATIC
    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Abrir conta");
        System.out.println("2 - Mostrar integrantes");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");
    }

    // STATIC POIS MAIN É STATIC
    private static void mostrarIntegrantes() {
        System.out.println("\nIntegrantes:");
        System.out.println("- Nicolas Pinheiro Bueno");
        System.out.println("- Guilherme Jefinny Souto");
        System.out.println("- João Tietbohl");
        System.out.println("- Enzo Bueno");
    }

    // STATIC POIS MAIN É STATIC
    private static void abrirConta(Scanner scanner) {
        System.out.println("\n--- Abertura de conta ---");

        char tipoConta = pedirTipoConta(scanner);

        // chama o método lá de baixo pra montar o cliente
        Cliente cliente = pedirDadosCliente(scanner);

        double saldoInicial = pedirDouble(scanner, "Saldo inicial: ");

        switch (tipoConta) {
            case 'C':
                double limiteCredito = pedirDouble(scanner, "Limite de crédito: ");

                // junta tudo que coletamos pra instanciar a conta de verdade (nesse caso a
                // corrente)
                ContaCorrente contaCorrente = new ContaCorrente(cliente, saldoInicial, limiteCredito);
                System.out.println("Conta Corrente criada com sucesso!");

                menuDaConta(scanner, contaCorrente);
                break;

            case 'P':
                System.out.println("Conta Poupança selecionada (Teste).");
                break;

            case 'I':
                Data vencimento = pedirVencimento(scanner); // método separado pra data
                ContaInvestimento contaInvestimento = new ContaInvestimento(cliente, saldoInicial, vencimento);
                System.out.println("Conta Investimento criada com sucesso!");
                menuDaConta(scanner, contaInvestimento);
            
                break;
            // System.out.println("Conta Investimento selecionada (Teste).");
                // break;
        }
    }

    // STATIC POIS MAIN É STATIC
    private static void menuDaConta(Scanner scanner, ContaBancaria conta) {
        boolean operando = true;

        while (operando) {
            System.out.println("\n--- Operações da Conta ---");
            System.out.println("1 - Realizar Depósito");
            System.out.println("2 - Realizar Saque");
            System.out.println("3 - Ver Extrato");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("5 - Aplicar Juros"); //teste, alterar ordem qnd vldado por tds
            System.out.print("Escolha: ");

            int escolha = scanner.nextInt();

            // limpa a quebra de linha que sobra no scanner pra não pular o próximo input
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    double valorDep = pedirDouble(scanner, "Valor do depósito: ");
                    conta.movimenta(new Operacao('D', valorDep));
                    break;
                case 2:
                    double valorSaq = pedirDouble(scanner, "Valor do saque: ");
                    conta.movimenta(new Operacao('S', valorSaq));
                    break;
                case 3:
                    conta.exibirExtrato();
                    break;
                case 4:
                    operando = false;
                    System.out.println("Saindo da conta...");
                    break;
                case 5:
                    double taxa = pedirDouble(scanner, "Taxa de juros (%): ");
                    conta.movimenta(new Operacao('J', taxa));
                    break;    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // STATIC POIS MAIN É STATIC
    // isola a criação do cliente pra não poluir o switch principal
    private static Cliente pedirDadosCliente(Scanner scanner) {
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

        // limpa a quebra de linha que sobra no scanner pra não pular o próximo input
        scanner.nextLine();

        Data data = new Data(dia, mes, ano);
        return new Cliente(nome, cpf, data);
    }

    // STATIC POIS MAIN É STATIC
    private static char pedirTipoConta(Scanner scanner) {
        // loop infinito pra prender o usuário até ele digitar uma letra válida

        while (true) {
            System.out.print("Tipo (C - Corrente, P - Poupança, I - Investimento): ");

            // trim pra remover os espaços e uppercase pra padronizar
            String entrada = scanner.nextLine().toUpperCase().trim();

            if (!entrada.isEmpty()) {
                char tipo = entrada.charAt(0);

                if (tipo == 'C' || tipo == 'P' || tipo == 'I') {
                    return tipo;
                }
            }

            System.out.println("Tipo inválido.");
        }
    }

    // STATIC POIS MAIN É STATIC
    private static double pedirDouble(Scanner scanner, String mensagem) {
        // loop infinito pra prender o usuário até ele digitar um valor válido

        while (true) {
            System.out.print(mensagem);
            String valorStr = scanner.nextLine();

            // usa nossa validação pra garantir que não vai quebrar o programa na conversão
            if (verificarNumero(valorStr)) {
                return Double.parseDouble(valorStr.trim());
            }

            System.out.println("Valor inválido.");
        }
    }

    // STATIC POIS MAIN É STATIC
    // usa o try/catch pra validar, se o parsedouble falhar n é numero
    private static boolean verificarNumero(String valorStr) {
        try {
            double valor = Double.parseDouble(valorStr.trim());
            return valor > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
//METODO PARA INPUT DE VENCIMENTO PARA C.INVST
    private static Data pedirVencimento(Scanner scanner) {
        int dia = (int) pedirDouble(scanner, "Dia do vencimento: ");
        int mes = (int) pedirDouble(scanner, "Mês do vencimento: ");
        int ano = (int) pedirDouble(scanner, "Ano do vencimento: ");

        return new Data(dia, mes, ano);
    }
}