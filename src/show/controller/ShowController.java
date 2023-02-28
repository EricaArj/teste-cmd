package show.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import repository.ShowRepository;
import show.model.Cadastro;
import show.model.ReservaCamarote;
import show.model.ReservaCamaroteEspecial;
import show.model.ReservaCamaroteTradicional;




public class ShowController implements ShowRepository {
	
	Scanner leia = new Scanner(System.in);
	
	private ArrayList<ReservaCamarote> listaReserva = new ArrayList<ReservaCamarote>();
	private ArrayList<Cadastro> cadastrarUsuario = new ArrayList<Cadastro>();

	char continuar;
	char confirmar;
	int numCam, pacote;
	String nomePacote;

	public boolean autenticar(String email, String senha) {
		for (Cadastro cadastro : cadastrarUsuario) {
			if (cadastro.getEmail().equals(email) && cadastro.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	public boolean dataNascimento(String dataN) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dob = LocalDate.parse(dataN, format);
		LocalDate curDate = LocalDate.now();
		if ((dob != null) && (curDate != null)) {
			if (Period.between(dob, curDate).getYears() >= 18)
				return true;
		}

		return false;

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
		// Listar a Cadastro para o usuário

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

	public Cadastro buscarNaCollection(String email) {
		for (var cadastro : cadastrarUsuario) {
			if (cadastro.getEmail() == email)
				return cadastro;
		}

		return null;
	}

	@Override
	public void listarTodas() {
		for (var reserva : listaReserva)
			reserva.visualizar();
		// Listar a reserva para o usuário

	}

	@Override
	public void cadastrar(Cadastro cadastro) {
		cadastrarUsuario.add(cadastro);
		// System.out.println("Cadastro Realizado com Sucesso!");
	}

	@Override
	public Cadastro retornaLogado(String email, String senha) {
		for (Cadastro cadastro : cadastrarUsuario) {
			if (cadastro.getEmail().equals(email) && cadastro.getSenha().equals(senha)) {
				return cadastro;
			}
		}
		return null;
	}

	
	public void criarCamarotesTradicionais() {

		for (int i = 0; i < 3; i++) {
			listaReserva.add(new ReservaCamaroteTradicional(true, "", (i + 1), 1, 0));
		}
	}


	public void criarCamarotesEspeciais() {
		for (int i = 0; i < 3; i++) {
			listaReserva.add(new ReservaCamaroteEspecial(true, "", (i + 1), 2, false));
		}
	}

	
	public boolean agendarCamarote(String nomeAgenda, int pacote) {

		if (pacote == 1) {
			nomePacote = "Tradicional";
			System.out.println("\n\n-> VOUCHER NO VALOR: " + 199.0f);
			System.out.println("• Curtir o show bem próximo do palco;");
			System.out.println("• Bebidas vodka, whisky e gin importados, suco, refrigerante e água.\n");
		} else {
			nomePacote = "Especial";
			System.out.println("\n\n-> ACESSO VIP AO CARDÁPIO");
			System.out.println("• Bebidas e alimentos à vontade;");
			System.out.println("• Localização com vista privilegiada;");
			System.out.println("• Banheiros Exclusivos;");
			System.out.println("• Acesso à balada após o show.\n");
		}

		// Caso a entrada não seja um inteiro, cria uma "exceção" a esse erro e recomeça
		// esse loop
		for (var reserva : listaReserva) {

			if (reserva.getTipoPacote() == pacote) {
				if (reserva.isDisponibildade() == true)
					System.out.println("Camarote " + nomePacote + " " + reserva.getEspacoCamarote() + " Disponível");
				else
					System.out.println("Camarote " + nomePacote + " " + reserva.getEspacoCamarote() + " Reservado");
			}
		}

		System.out.println("\n");

		do {
			System.out.println("\nDigite número do Camarote:");

			try {
				numCam = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				numCam = 0;
				continue;
			}

			// Se o número for menor que 1 ou maiior que 4, recomeça o loop
			if (numCam < 1 || numCam > 3)
				System.out.println("\nDigite um número entre 1 e 3!");

		} while (numCam < 1 || numCam > 3);

		if (reservado(numCam, pacote, nomeAgenda) == false) {
			System.out.println("\nCamarote reservado. Favor escolher outro\n");
			System.out.println("\nAgendar outro Camarote? (S/N)\n");
			continuar = leia.next().charAt(0);
			if (continuar == 's' || continuar == 'S')
				return true;
			return false;

		}

		System.out.println("\nConfirmar agendamento? (S/N)\n");
		confirmar = leia.next().charAt(0);
		if (confirmar == 's' || confirmar == 'S') {
			adicionarReserva(numCam, pacote, nomeAgenda);
			return false;

		}
		return true;
	}

	@Override
	public void conferirAgendamento(String nome, int numCam, int pacote) {
		var buscarReserva = buscarResNaCollection(nome, numCam, pacote);

		if (buscarReserva != null) {

			buscarReserva.visualizar();

		} else
			System.out.println("\nA Reserva não foi encontrada!");

	}

	@Override
	public void cancelarReserva(String nome, int numCam, int pacote) {
		var buscarReserva = buscarResNaCollection(nome, numCam, pacote);

		if (buscarReserva != null) {

			if (buscarReserva.getTipoPacote() == 1)
				listaReserva.set(listaReserva.indexOf(buscarReserva),
						new ReservaCamaroteTradicional(true, "", buscarReserva.getEspacoCamarote(), 1, 0));
			else
				listaReserva.set(listaReserva.indexOf(buscarReserva),
						new ReservaCamaroteEspecial(true, "", buscarReserva.getEspacoCamarote(), 2, false));
		} else
			System.out.println("\nA Reserva não foi encontrada!");

	}

	public ReservaCamarote buscarResNaCollection(String nome, int numCam, int pacote) {
		for (var reserva : listaReserva) {
			if (reserva.getNome().contains(nome) && reserva.getEspacoCamarote() == numCam
					&& reserva.getTipoPacote() == pacote) {
				return reserva;
			}
		}

		return null;
	}

	private boolean reservado(int numCam, int pacote, String nomeAgenda) {

		for (var reserva : listaReserva) {

			if (reserva.getTipoPacote() == pacote) {
				// System.out.println(reserva.getTipoPacote());
				if (reserva.getEspacoCamarote() == numCam) {

					if (reserva.isDisponibildade() == false)
						return false;
				}
			}
		}
		return true;
	}

	private void adicionarReserva(int numCam, int pacote, String nomeAgenda) {

		var buscarReserva = buscarNaCollection(numCam, pacote);
		ReservaCamarote reserva;

		if (pacote == 1) {
			reserva = listaReserva.set(listaReserva.indexOf(buscarReserva),
					new ReservaCamaroteTradicional(false, nomeAgenda, numCam, pacote, 100.0f));
		} else {
			reserva = listaReserva.set(listaReserva.indexOf(buscarReserva),
					new ReservaCamaroteEspecial(false, nomeAgenda, numCam, pacote, true));
		}
		reserva.visualizar();

	}

	private ReservaCamarote buscarNaCollection(int numCam, int pacote) {
		for (var reserva : listaReserva) {
			if ((reserva.getEspacoCamarote() == numCam) && (reserva.getTipoPacote() == pacote)) {
				return reserva;
			}
		}

		return null;
	}

	@Override
	public void listarCadastro(Cadastro cadastro) {
		// TODO Auto-generated method stub

	}

}
