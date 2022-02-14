package logica;

import java.util.ArrayList;
import java.util.List;

public class ventas {
private static int numeroPedidos;
	
	private  int idPedido;
	
	private  String NombreCliente;
	
	private  String DireccionCliente;
	
	private List<producto> itemsPedido;
	
	public ventas(String pnombreCliente, String pdireccionCliente)
	
	{
		NombreCliente = pnombreCliente;
		DireccionCliente = pdireccionCliente;
		itemsPedido = new ArrayList<>();
		idPedido = (int)(Math. random()*100+1); 
		numeroPedidos += 1;
	}
	
	public int getIdPedido()
	{
		return idPedido;
	}
	
	public void agregarProducto(producto nuevoItem)
	{
		itemsPedido.add(nuevoItem);
	}
	
	private int getPrecioNetoPedido()
	{
		int precioNeto = 0;
		for (producto item : itemsPedido)
		{
			int precio = item.getPrecio();
			precioNeto += precio;
		}
		
		return precioNeto;
	}
	
	private int getCaloriasTotal()
	{
		int totalCalorias = 0;
		for (producto item : itemsPedido)
		{
			int calorias = item.getCalorias();
			totalCalorias += calorias;
		}
		
		return totalCalorias;
	}
	
	private int getPrecioIvaPedido()
	{
		
		int precioNeto = getPrecioNetoPedido();
		int precioIva = (int)(precioNeto*(0.19));
		
		return precioIva;
	}
	
	private int getPrecioTotalPedido()
	{
		int precioTotal = 0;
		int precioNeto = getPrecioNetoPedido();
		int precioIva = getPrecioIvaPedido();
		precioTotal = precioNeto+precioIva;
		
		return precioTotal;
	}
	
	public String generarFacturaTexto()
	{
		String factura = "Factura: ";
		
		factura += String.valueOf(idPedido) + "\n";
		
		factura += "Nombre: " + NombreCliente + ": " + "\n";
		
		factura += "Direccion: " + DireccionCliente + ": " + "\n";
		
		factura += "Numero de pedido: " + String.valueOf(numeroPedidos) + ": " + "\n";
		
		for (producto item : itemsPedido)
		{
			factura += item.generarFacturaTexto() + "\n";
		}
		
		int precioNeto = getPrecioNetoPedido();
		factura += "Precio Neto: " + String.valueOf(precioNeto) + "\n";
		
		int  precioIVA = getPrecioIvaPedido();
		factura += "Precio IVA: " + String.valueOf(precioIVA) + "\n";
		
		int precioTotal = getPrecioTotalPedido();
		factura += "Precio Total: " + String.valueOf(precioTotal) + "\n";
		
		int caloriasTotal = getCaloriasTotal();
		factura += "Calorias Total: " + String.valueOf(caloriasTotal) + "\n";
		
		return factura;
	}

}