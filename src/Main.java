import modelos.Cliente;
import modelos.Data;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);

            Cliente cliente = new Cliente();

            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();

            cliente.setNome(nome);

            System.out.println("Digite seu CPF: ");
            String cpf = scanner.nextLine();

            cliente.setCpf(cpf);

            System.out.println("Digite sua data de nascimento");
        } catch (Exception exception) {
            System.out.println("Erro");
        }
    }
}