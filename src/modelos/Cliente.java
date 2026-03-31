package modelos;

import java.util.Date;

public class Cliente {

    private String nome;
    private String cpf;
    private Date dtNascimento;

    public Cliente(String nome, String cpf, Date dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}