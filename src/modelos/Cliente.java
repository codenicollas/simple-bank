package modelos;

public class Cliente {

    private String nome;
    private String cpf;
    private Data dtNascimento;

    public Cliente(String nome, String cpf, Data dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Data getDtNascimento() {
        return this.dtNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nData de nascimento: " + this.dtNascimento.toString();
    }
}