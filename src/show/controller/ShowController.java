package show.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
	
	
	
	public boolean autenticar(String email, String senha) {
        for (Cadastro cadastro : cadastrarUsuario) {
            if (cadastro.getTelefone().equals(email) && cadastro.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    public Cadastro buscarNaCollection(String email) {
		for (var cadastro : cadastrarUsuario) {
			if (cadastro.getTelefone() == email)
				return cadastro;
		}

		return null;
    }
		
    public Cadastro dataNascimento(String data) {
		try {	
			System.out.print("Entre com a data de nascimento DD/MM/AAAA formatada: ");
			Scanner scanner = new Scanner(System.in);
		
			String dataN = scanner.nextLine();
			scanner.close();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			
			LocalDate dob = LocalDate.parse(dataN, format);
			
			
			// prints the age
			System.out.println("Você tem " + calculateAge(dob) + " anos de idade");
	}catch (DateTimeParseException e) {
		System.out.println("Informe a data de acordo com o exemplo {DD/MM/AAAA}!");
	}
		return null;
	
}

	public static int calculateAge(LocalDate dob) {

		LocalDate curDate = LocalDate.now();
		if ((dob != null) && (curDate != null)) {
			return Period.between(dob, curDate).getYears();
		} else {
			return 0;
		}
	}
		
    public void listarCadastro() {
		for (var cadastro : cadastrarUsuario)
			cadastro.visualizar();
		//Listar a Cadastro para o usuário
		
	}
    
    public void procurarPorEmail(String email) {
		var cadastro = buscarNaCollection(email);

		if (cadastro != null)
			cadastro.visualizar();
		else
			System.out.println("O Cadastro do Email: " + email + " não foi encontrada!");
	}
    
    public void deletar(String email) {
		var cadastro = buscarNaCollection(email);

		if (cadastro != null) {
			if (cadastrarUsuario.remove(cadastro) == true)
				System.out.println("O Cadastro do Email: " + email + " foi excluído!");
		} else
			System.out.println("O Cadastro do Email: " + email + " não foi encontrada!");

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
			//System.out.println("Cadastro Realizado com Sucesso!");
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
	@Override
	public void listarCadastro(Cadastro cadastro) {
		// TODO Auto-generated method stub
		
	}	
		
		
	
	
	
	


}
