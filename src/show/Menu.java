package show;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import show.controller.ShowController;
import show.model.Cadastro;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		ShowController cliente = new ShowController();
		
		Cadastro c1 = new Cadastro(1, "Brian Schneider de Lima", "R1p4rT3ex", "123.456.789-01", "Masculino", "(11)98765-4321", LocalDate.of(1994, 10, 6), "brian@generation.com");
		Cadastro c2 = new Cadastro(2, "Vinicius Prazeres", "E#30y0@*", "987.654.321-10", "Masculino", "(11)91234-5678", LocalDate.of(1995, 5, 13), "vprazeres@generation.com");
		Cadastro c3 = new Cadastro(3, "Erica Araújo da silva Oliveira", "m5R&8t5h", "444.333.55-22", "Feminino", "(11)98237-4765", LocalDate.of(1997, 8, 24), "ericaraujo@generation.com");
		Cadastro c4 = new Cadastro(4, "Jennifer Cruz", "%0p%L52%", "842.632.919-87", "Feminino", "(11)98888-7777", LocalDate.of(1997, 11, 16), "jennifercruz@generation.com");
		
		cliente.cadastrar(c1);
		cliente.cadastrar(c2);
		cliente.cadastrar(c3);
		cliente.cadastrar(c4);
		
		cliente.criarCamarotes(4);
		
		int opcao, numCam, pacote;
		
		long id;
		String nome, senha, cpf, sexo, telefone, email;
		LocalDate dataNascimento;
		

		int  tipoSexo, idade;
	    
	    while (true) {
	    	
	    	System.out.println("--------------------------------\n");
			System.out.println("Bem-vindo ao sistema de RESERVA!");
			System.out.println("______________MENU_______________\n");
			System.out.println("	Escolha uma opção:		");
			System.out.println("	1- CRIAR CADASTRO    	");
			System.out.println("	2- LOGIN				");
			System.out.println("	3- VISUALIZAR CADASTRO	");
			System.out.println("	4- BUSCAR CADASTRO		");
			System.out.println("	5- Cliente(PACOTE)		");
			System.out.println("	6- APAGAR CLIENTE		");
			System.out.println("	7- CONSULTAR (CAMAROTE)	");			
			System.out.println("	0 - Sair				");
			System.out.println("__________________________________\n");
			System.out.println("Entre com a opção desejada:      ");
			System.out.println("			  					");

			int opcao1;
			
			try {
				opcao1 = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Digite valores inteiros de 0 a 6! ");
				leia.nextLine();
				opcao1 = 0;
				
			}


			if (opcao1 == 0) {

				System.out.println("#####################################################################");
				System.out.println("\n  		CMD - RELIZAMOS OS SEUS SONHOS						 	 ");
				System.out.println("\n			TENHA UM OTIMO DIA! 									 ");
				System.out.println("#####################################################################");
				leia.close();
				System.exit(0);

			}
			switch (opcao1) {
			case 1:
				System.out.println("Criar Cadastro \n\n");

				System.out.println("Realizando cadastro...");
				System.out.print("Informe seu nome: ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				System.out.print("Senha: ");
				leia.skip("\\R?");
				senha = leia.nextLine();
				System.out.print("\n");

				System.out.println("CPF: ");
				leia.skip("\\R?");
				cpf = leia.nextLine();

				System.out.println("Informe o Sexo ");

				do {
					System.out.println("Sexo -> (1-Mulher | 2-Homem | 3-Outros): ");
					tipoSexo = leia.nextInt();
				} while (tipoSexo < 1 && tipoSexo > 3);

				switch (tipoSexo) {
				case 1 -> {
					System.out.println("Mulheres tem direito de descontos de 20%");

//					limite = leia.nextFloat();
//					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

				}
				case 2 -> {
					System.out.println("Homem ");
//					aniversario = leia.nextInt();
//					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				case 3 -> {
					System.out.println("Outros: ");

//					aniversario = leia.nextInt();
//					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}

				System.out.println("Digite seu telefone/celular: ");
				leia.skip("\\R?");
				telefone = leia.nextLine();

				System.out.println("Qual sua idade: ");
				leia.skip("\\R?");
				idade = leia.nextInt();
				if (idade >= 18) {
					System.out.println("Seja bem vindo(a)!");

				} else {
					System.out.println("Desculpa! Menores de idade não é possivel parcicipar");
					break;
				}

				keyPress();
				break;
			case 2:
				System.out.print("------------------------------\n");
				System.out.println("Realizando Login...");
				
				System.out.print("------------------------------\n");
				
		        System.out.print("Digite o seu Email: ");
		        String emaillogin = leia.next();
		        System.out.print("\nSenha: ");
		        String senhalogin = leia.next();
		        
		        boolean login = cliente.autenticar(emaillogin,senhalogin);
		        
		        if (login) {
		        	System.out.print("------------------------------\n");
		            System.out.println("\nAutenticado com sucesso!");
		            System.out.print("------------------------------\n");
		            // Código para redirecionar o usuário para a página principal
		        } else {
		        	System.out.print("------------------------------");
		            System.out.println("\nNome de usuário ou senha inválidos!");
		            System.out.print("------------------------------");
		            // Código para exibir uma mensagem de erro ao usuário
		        }
		        keyPress();
				 break;
			case 3:
				System.out.println("cliente(Pacote)\n\n");

				break;
			case 4:
				System.out.println("Pedido\n\n");

				break;
			case 5:
				System.out.println("Camarote\n\n");
				
				System.out.println("Digite nome dono camarote:");
				leia.skip("\\R?");
				nome = leia.nextLine();
				
				do {
					System.out.println("\nDigite numero camarote:");
					
					//Caso a entrada não seja um inteiro, cria uma "exceção" a esse erro e recomeça esse loop
					try {
						numCam = leia.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("\nDigite valores inteiros!");
						leia.nextLine();
						numCam = 0;
						continue;
					}
					
					//Se o número for menor que 1 ou maiior que 4, recomeça o loop
					if(numCam < 1 || numCam > 4)
						System.out.println("Digite um número entre 1 e 4!");
					
				} while(numCam < 1 || numCam > 4);
				
				System.out.println("\nDigite numero camarote:");
				pacote = leia.nextInt();
				
				cliente.agendarCamarote(nome, numCam, pacote);
				
				
				break;
			case 6:
				System.out.println("Consultar cliente\n\n");
				cliente.listarTodas();
				
				
				break;
			default:
				System.out.println("\nSaindo do sistema!\n Muito Obrigado!");
				break;
			}

		}
		
	}	
	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}

	
