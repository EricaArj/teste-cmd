package show.controller;

import java.util.ArrayList;
import java.util.Scanner;

import repository.ShowRepository;
import show.model.Cadastro;
import show.model.ListaCamarote;
import show.model.ReservaCamarote;



public class ShowController implements ShowRepository {
	
	Scanner leia = new Scanner(System.in);
	
	private ArrayList<ReservaCamarote> listaReserva = new ArrayList<ReservaCamarote>();
	private ArrayList<Cadastro> cadastrarUsuario = new ArrayList<Cadastro>();
	private ArrayList<ListaCamarote> camaroteDisp = new ArrayList<ListaCamarote>();
	
	char continuar;
	char confirmar;
	int numCam, pacote;
	
	
	
	 
    public boolean autenticar(String telefone, String senha) {
        for (Cadastro cadastro : cadastrarUsuario) {
            if (cadastro.getTelefone().equals(telefone) && cadastro.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    public Cadastro buscarNaCollection(String telefone) {
		for (var cadastro : cadastrarUsuario) {
			if (cadastro.getTelefone() == telefone)
				return cadastro;
		}

		return null;

	}
	
	
	@Override
	public void listarTodas() {
		for (var reserva : listaReserva)
			reserva.visualizar();
		//Listar a reserva para o usuário
		
	}
	
	@Override
	public void cadastrar(Cadastro cadastro) {
		
		cadastrarUsuario.add(cadastro);
		System.out.println("Cadastro Realizado com Sucesso.");
		
	}
	
	@Override
	public void criarCamarotes(int n) {
		
		for(int i = 0; i < 4; i++) {
			camaroteDisp.add(new ListaCamarote(true, "", 0));
		}	
		
	}
	
	@Override
	public void agendarCamarote(String nomeAgenda, int numCam, int pacote) {	
		
		for(int i = 0; i < camaroteDisp.size(); i++) {
			ListaCamarote exibirCamarotes = camaroteDisp.get(i);
			if(exibirCamarotes.isDisponibildade() == true)
				System.out.println("Camarote " + (i + 1) + " Disponível");
			else
				System.out.println("Camarote " + (i + 1) + " Reservado");
		}
		
		
		do {
			
			do {
				
				
				//Instancia um objeto do tipo ListaCamarotes em fundão de seu Index
				ListaCamarote camaroteSelecionado = camaroteDisp.get(numCam - 1);
				
				//Se o camarote ja estiver reservado (false), reiniciar o loop caso a pessoa queira
				if(camaroteSelecionado.isDisponibildade() == false) {
					
					System.out.println("\nCamarote reservado. Favor escolher outro");
					System.out.println("\nContinuar? (S/N)\n");
					continuar = leia.next().charAt(0);
					if(continuar == 'n' || continuar == 'N') {
						leia.close();
						System.exit(0);
						
					}
				}
			
			} while(camaroteDisp.get(numCam - 1).isDisponibildade() == false);
			
			//Se o camarote selecionado estiver Disponível (true), mudar seu status para Reservado (false)
			camaroteDisp.get(numCam - 1).setDisponibildade(false);
			
			
			//Adicinoar o nome da pessoa que reservou e o pacote que ela selecionou
			camaroteDisp.get(numCam - 1).setNomeAgenda(nomeAgenda);
			camaroteDisp.get(numCam - 1).setPacote(pacote);
			
			System.out.println("\nConfirmar agendamento? (S/N)\n");
			confirmar = leia.next().charAt(0);
			
		} while(confirmar == 'n' || confirmar == 'N');
		
		camaroteDisp.get(numCam - 1).visualizar();
	}	
		
		
	
	
	
	


}
