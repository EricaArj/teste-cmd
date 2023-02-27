package repository;

import show.model.Cadastro;

public interface ShowRepository {
	
	public void listarTodas();
	public void cadastrar(Cadastro cadastro);
	public void criarCamarotes(int n);
	public void agendarCamarote(String nomeAgenda, int numCam, int pacote);
	void listarCadastro(Cadastro cadastro);
	void procurarPorEmail(String email);

}
