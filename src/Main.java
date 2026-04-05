import java.util.Scanner;

import modelos.Cliente;
import modelos.ContaCorrente;
import modelos.Data;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;

        while (rodando) {
            System.out.println("Bem-vindo ao aplicativo bancário: ");
            System.out.println("");
            System.out.println("Menu de opções: ");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Mostrar integrantes do grupo");
            System.out.println("3 - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite qual tipo de conta voce deseja abrir");
                    System.out.println(
                            "Digite os seguintes dígitos em:\n" +
                                    "C - Corrente\n" +
                                    "P - Poupança\n" +
                                    "I - Investimento");

                    char tipoConta = scanner.next().charAt(0);

                    Cliente cliente = pedirDados(scanner);

                    switch (tipoConta) {
                        case 'C':
                            System.out.println("A conta que voce criou é --CORRENTE--");
                            ContaCorrente contaCorrente = new ContaCorrente(cliente, 0, 0);
                            break;
                        case 'P':
                            System.out.println("A Conta que voce criou é --POUPANÇA-- ");
                            break;
                        case 'I':
                            System.out.println("A conta que você criou é --INVESTIMENTO--");

                            break;
                        default:
                            System.out.println("Entrada inválida.");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Integrantes do grupo:");
                    System.out.println("* Nicolas Pinheiro Bueno");
                    System.out.println("* Guilherme Jefinny Souto");
                    System.out.println("* João Tietbohl");
                    System.out.println("* Enzo Bueno");
                    break;
                case 3:
                    rodando = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    rodando = false;
                    System.out.println("Escolha inválida!");
                    break;
            }
        }
    }

    private static Cliente pedirDados(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite seu dia de nascimento: ");
        int dia = scanner.nextInt();

        System.out.println("Digite o seu mês de nascimento: ");
        int mes = scanner.nextInt();

        System.out.println("Digite seu ano de nascimento: ");
        int ano = scanner.nextInt();

        Data data = new Data(dia, mes, ano);

        return new Cliente(nome, cpf, data);
    }

    private boolean verificarNumero(String valorStr) {
        try {
            double valor = Double.parseDouble(valorStr.trim());
            return valor > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}