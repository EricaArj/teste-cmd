package show.model;

import java.time.LocalDate;

public class Cadastro {

    private String nome; 
    private String senha;
    private String cpf;
    private int tipoSexo;
    private String telefone;
    private int idade;

    public Cadastro(String nome, String senha, String cpf, int tipoSexo, String telefone, int idade) {

        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.tipoSexo = tipoSexo;
        this.telefone = telefone;
        this.idade = idade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(int tipoSexo) {
        this.tipoSexo = tipoSexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void visualizar(){

        System.out.println("----------------------------------------");
        System.out.println("            DADOS DE CADASTRO           ");
        System.out.println("----------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Senha: " + this.senha);
        System.out.println("Sua idade: " + this.idade);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Sexo: " + this.tipoSexo);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("----------------------------------------");


    }

}