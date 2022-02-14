package logica;

public class productoMenu implements producto {
	private String nombre;

	private int precioB;
	
	private int calorias;
	
	public productoMenu(String pnombre, int pprecioB, int pCalorias)
	{
		nombre = pnombre;
		precioB= pprecioB;
		calorias = pCalorias;

	}

	public String getNombre()
	{
		return nombre;
	}
	
	public int getPrecio()
	{
		return precioB;
	}
	
	public String generarFacturaTexto()
	{
		String Factura = nombre+ " $ " + String.valueOf(precioB) + " calorias: " + String.valueOf(calorias);
		return Factura;
	}
	
	public String toString()
	{
		return nombre + " (" +precioB+ ")";
	}

	public int getCalorias() 
	{
		return calorias;
	}

}
