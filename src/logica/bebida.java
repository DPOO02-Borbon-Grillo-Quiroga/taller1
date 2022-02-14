package logica;

public class bebida {
	private String nombre;

	private int precioBase;
	
	private int calorias;

	public bebida(String pnombre, int pprecioB,int pcalorias)
	{
		nombre = pnombre;
		precioBase = pprecioB;
		calorias = pcalorias;
	}
	
	public String getNombre() 
	{
		return nombre;
	}

	public int getPrecio() 
	{
		return precioBase;
	}

	public String generarFacturaTexto() 
	{
		String Factura = nombre + " $ " + String.valueOf(precioBase) + " cal: " + String.valueOf(calorias);
		return Factura;
	}
	
	public int getCalorias() 
	{
		return calorias;
	}

}