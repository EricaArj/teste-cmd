package show.model;

public abstract class ReservaCamarote {
	
	private boolean disponibildade;
    private String nome;
    private int espacoCamarote;
    private int tipoPacote;

	


	public ReservaCamarote(boolean disponibildade, String nome, int espacoCamarote, int tipoPacote) {
	
		this.disponibildade = disponibildade;
		this.nome = nome;
		this.espacoCamarote = espacoCamarote;
		this.tipoPacote = tipoPacote;
	}




	public boolean isDisponibildade() {
		return disponibildade;
	}




	public void setDisponibildade(boolean disponibildade) {
		this.disponibildade = disponibildade;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public int getEspacoCamarote() {
		return espacoCamarote;
	}




	public void setEspacoCamarote(int espacoCamarote) {
		this.espacoCamarote = espacoCamarote;
	}




	public int getTipoPacote() {
		return tipoPacote;
	}




	public void setTipoPacote(int tipoPacote) {
		this.tipoPacote = tipoPacote;
	}




	public void visualizar() {
		
		String disponibilidade = "";

        if (this.disponibildade == true)
            disponibilidade = "Disponível";
        else
            disponibilidade = "Reservado";
		String tipo = "";
		
		switch(this.tipoPacote) {		
		case 1 -> tipo = "Reserva Camarote (Especial)";
		case 2 -> tipo = "Reserva Camarote (Tradisonal)";
		
	}	
		
	//boolean disponibildade, String nome, int espacoCamarote, int tipoPacote
	System.out.println("#######################");	
	System.out.println("   RESERVA CAMAROTE    ");	
	System.out.println("#######################");	
	System.out.println("Nome: " + this.nome);			
	System.out.println("Tipo de Reserva Camarote: " + tipo);
	System.out.println("Escolha o numero do camarote: " + this.espacoCamarote);
	System.out.println("Camarotes Disponivel: " + disponibilidade);	
	System.out.println("########################");
	
   }
}
