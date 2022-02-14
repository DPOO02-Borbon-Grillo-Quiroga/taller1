package logica;

import java.util.ArrayList;
import java.util.List;

public class comboMod implements producto{
	private String nombreCombo;

	private double desc;
	
	private List<producto> itemsCombo;
	
	private int precioTotal;
	
	private int calorias;
	
	public comboMod(String pnombre, double pdescuento)
	{
		nombreCombo=pnombre;
		desc=pdescuento;
		itemsCombo=new ArrayList<>();
	}
	
	public void agregarItemACombo(producto itemCombo)
	{
		
		itemsCombo.add(itemCombo);
		precioTotal+=(int)(itemCombo.getPrecio()*((100-desc)/100));
		calorias += (int)(itemCombo.getCalorias());

	}
	
	public String getNombre()
	{
		return nombreCombo;
	}
	
	public int getPrecio()
	{
		return precioTotal;
	}
	
	public String generarFacturaTexto()
	{
		String Factura = nombreCombo + " $ " +String.valueOf(precioTotal)+ " cal: " +String.valueOf(calorias);
		return Factura;
	}
	
	public String toString()
	{
		return nombreCombo + " (" + precioTotal + ")" + " (" + calorias + ")";
	}
	public int getCalorias() 
	{
		return calorias;
	}

}