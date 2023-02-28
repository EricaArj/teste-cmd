package show.model;

public class ReservaCamaroteTradicional extends ReservaCamarote {

	private float valorDisponivel;


	public ReservaCamaroteTradicional(boolean disponibildade, String nome, int espacoCamarote, int tipoPacote,
			float valorDisponivel) {
		super(disponibildade, nome, espacoCamarote, tipoPacote);
		this.valorDisponivel = valorDisponivel;
	}

	public float getValorDisponivel() {
		return valorDisponivel;
	}

	public void setValorDisponivel(float valorDisponivel) {
		this.valorDisponivel = valorDisponivel;
	}
	
	
	public void visualizar() {
		super.visualizar();
		System.out.println("-> VOUCHER NO VALOR: " + this.valorDisponivel);
		System.out.println("• Curtir o show bem próximo do palco;");
		System.out.println("• Bebidas vodka, whisky e gin importados, suco, refrigerante e água.");

		
	}
	
}
