package logica;

public class ingrediente {
	
	private String nombre;

	private int CostoAd;
	
	private int calorias;
	
	public ingrediente(String pnombre, int pCostoAd, int pCalorias)
	{
		this.nombre = pnombre;
		this.CostoAd = pCostoAd;
		calorias = pCalorias;

	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getCostoAdicional()
	{
		return CostoAd;
	}
	
	public int getCalorias()
	{
		return calorias;
	}
	
}
