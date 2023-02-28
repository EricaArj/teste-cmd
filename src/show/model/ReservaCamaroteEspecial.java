package show.model;

public class ReservaCamaroteEspecial extends ReservaCamarote{
	
	private boolean acessoVip;


	public ReservaCamaroteEspecial(boolean disponibildade, String nome, int espacoCamarote, int tipoPacote,
			boolean acessoVip) {
		super(disponibildade, nome, espacoCamarote, tipoPacote);
		this.acessoVip = acessoVip;
	}

	public boolean isAcessoVip() {
		return acessoVip;
	}

	public void setAcessoVip(boolean acessoVip) {
		this.acessoVip = acessoVip;
	}
	
	public void visualizar() {
		super.visualizar();
		//ACESSO AO CARDÁPIO ->Tratativa VIP ou não
		System.out.println("-> ACESSO VIP AO CARDÁPIO");
		System.out.println("• Bebidas e alimentos à vontade;");
		System.out.println("• Localização com vista privilegiada;");
		System.out.println("• Banheiros Exclusivos;");
		System.out.println("• Acesso à balada após o show.");

		
	}
	
}
