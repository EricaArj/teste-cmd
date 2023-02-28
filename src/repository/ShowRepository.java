package repository;

import show.model.Cadastro;

public interface ShowRepository {
	
	public void listarTodas();
	public void cadastrar(Cadastro cadastro);
	void listarCadastro(Cadastro cadastro);
	void procurarPorEmail(String email);
	public Cadastro retornaLogado(String email, String senha);
	void cancelarReserva(String nome, int numCam, int pacote);
	void conferirAgendamento(String nome, int numCam, int pacote);
	boolean agendarCamarote(String nomeAgenda, int pacote);
	void criarCamarotesTradicionais();
	void criarCamarotesEspeciais();
}
