package logica;

import java.util.ArrayList;
import java.util.List;

public class productoAjustado implements producto {
	
	private  List<ingrediente> adiciones;
	
	private  List<ingrediente> eliminados;
	
	private String nombre;
	
	private int precio;
	
	private int calorias;

	public productoAjustado(productoMenu b)
	{

		nombre=b.getNombre();
		precio=b.getPrecio();
		adiciones=new ArrayList<>();
		eliminados=new ArrayList<>();
		calorias=b.getCalorias();
	}
	
	public String generarFacturaTexto()
	{
		String adiciona = "";
		String elimina = "";
		String factura = "";
		for (ingrediente aingrediente : adiciones)
		{	
			adiciona+="Se le adiciono: " + aingrediente.getNombre();
		}
		
		for (ingrediente eingrediente : eliminados)
		{	
			elimina+="Se quito " + eingrediente.getNombre();
		}
		factura = nombre + adiciona + elimina + " $ " + String.valueOf(precio) + " calorias: " +  String.valueOf(calorias);
		return factura;
	}
	
	public String getNombre()
	{
		for (ingrediente aingrediente : adiciones)
		{	
				nombre += "Se le adiciono " + aingrediente.getNombre();
		}
		
		for (ingrediente eingrediente : eliminados)
		{	
				nombre += "Se quito " + eingrediente.getNombre();
		}
		return nombre;
	}
	
	public int getPrecio()
	{
		return precio;
	}
	
	public  void agregarIngrediente(ingrediente nIngrediente)
	{
		adiciones.add(nIngrediente);
		precio+=nIngrediente.getCostoAdicional();
		calorias+=nIngrediente.getCalorias();
	}
	
	public  void quitarIngrediente(ingrediente ingredientequitar)
	{
		eliminados.add(ingredientequitar);
	}

	public int getCalorias() 
	{
		return calorias;
	}
}