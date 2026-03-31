import modelos.Cliente;
import modelos.Data;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);

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

            cliente.exibirDados();
        } catch (Exception exception) {
            System.out.println("Erro");
        }
    }
}