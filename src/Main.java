import java.util.Scanner;

import modelos.Cliente;
import modelos.ContaBancaria;
import modelos.Data;
import modelos.Operacao;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

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
            Cliente cliente = new Cliente(nome, cpf, data);

            if (cliente != null) {
                System.out.println("Digite o tipo de operação que você quer realizar: ");
                System.out.println("Insira D para deposito e S para saque");
                String tipo = scanner.nextLine().strip();

                System.out.println("");

                System.out.println("Insira um valor: ");
                double valor = scanner.nextDouble();

                Operacao operacao = new Operacao(tipo.charAt(0), valor);
            }

            System.out.println(cliente);
        } catch (Exception exception) {
            System.out.println("Erro");
        }
    }
}