package logica;

import java.util.ArrayList;
import java.util.List;

public class combo implements producto {
	
	private String nombreC;
	
	private String respuesta;

	private double desc;
	
	private List<productoMenu> itemsCombo;
	
	private int precio;
	
	private int calorias;
	
	public combo(String pnombre, double pdescuento)
	{
		
		nombreC=pnombre;
		desc=pdescuento;
		itemsCombo = new ArrayList<>();

	}
	
	public void agregarItemACombo(productoMenu itemCombo)
	{	
		itemsCombo.add(itemCombo);
		precio+=(int)(itemCombo.getPrecio()*((100-desc)/100));
		calorias+=(int)(itemCombo.getCalorias());

	}
	
	public String getNombre()
	{
		return nombreC;
	}
	
	public int getPrecio()
	{
		return precio;
	}
	
	public String generarFacturaTexto()
	{
		String FacturaDef=nombreC+ " $ " +String.valueOf(precio) + " calorias: " +String.valueOf(calorias);
		return FacturaDef;
	}
	
	public String toString()
	{
		respuesta= nombreC+" (" + precio + ")";
		return respuesta;
	}

	public int getCalorias() 
	{
		return calorias;
	}

}