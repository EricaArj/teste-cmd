package show.model;

import java.time.LocalDate;

public class Cadastro {

    private String nome; 
    private String senha;
    private String cpf;
    private int tipoSexo;
    private String telefone;
    private String dataNascimento;
    private String email;
   

    public Cadastro(String nome, String senha, String cpf, int tipoSexo, String telefone, String dataNascimento,
			String email) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.tipoSexo = tipoSexo;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void visualizar(){

        System.out.println("----------------------------------------");
        System.out.println("            DADOS DE CADASTRO           ");
        System.out.println("----------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Senha: " + this.senha);
        System.out.println("Email: " + this.email);
        System.out.println("Sua idade: " + this.dataNascimento);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Sexo: " + this.tipoSexo);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("----------------------------------------");


    }

}