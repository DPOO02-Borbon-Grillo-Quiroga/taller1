package restaurante;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.ingrediente;
import logica.ventas;
import restaurante.restaurante;
import logica.productoMenu;
import logica.bebida;
import logica.comboMod;

public class restaurante {

	private static List<ingrediente> ingredientes;
	
	private static List<productoMenu> menu;
	
	private static List<comboMod> combos;
	
	private static  List<bebida> bebidas;
	
	private static  Map<String,ventas> pedidos;
	
	private static ventas ventaCurso;

	public  static List<productoMenu> getMenuBase()
	{
		return menu;
	}
	
	public static List<ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	
	public static List<comboMod> getCombos()
	{
		return combos;
	}
	
	public static List<bebida> getBebidas()
	{
		return bebidas;
	}
	
	public static void cargarInformacion(String a1,String a2,String a3,String a4) throws FileNotFoundException, IOException
	{
		ingredientes = cargarIngredientes(a1);
		menu=cargarMenu(a2);
		bebidas=cargarBebidas(a4);
		combos=cargarCombos(a3);
		pedidos=new HashMap<String, ventas>();
	}
	
	private static List<ingrediente> cargarIngredientes(String nArchivo) throws FileNotFoundException, IOException
	{
		List<ingrediente> listaIngredientes=new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(nArchivo));
		String linea = br.readLine();
		while (linea != null)
		{
			String[] parte=linea.split(";");
			String nombreIngrediente=parte[0];
			int precioad=Integer.parseInt(parte[1]);
			int pcaloriasIngredientes=Integer.parseInt(parte[2]);
			ingrediente cIngrediente=new ingrediente(nombreIngrediente,precioad,pcaloriasIngredientes);
			listaIngredientes.add(cIngrediente);

			linea = br.readLine();
		}
		br.close();
		return listaIngredientes;
	}
	
	
	private static List<productoMenu> cargarMenu(String nArchivo) throws FileNotFoundException, IOException
	{
		List<productoMenu> listaMenu = new ArrayList<>();
		BufferedReader br=new BufferedReader(new FileReader(nArchivo));
		String linea=br.readLine();
		while (linea!=null) 
		{
			String[] parte=linea.split(";");
			String nombreMenu=parte[0];
			int precioBase=Integer.parseInt(parte[1]);
			int pcaloriasMenuProducto=Integer.parseInt(parte[2]);
			productoMenu Menu=new productoMenu(nombreMenu,precioBase,pcaloriasMenuProducto);
			listaMenu.add(Menu);
			linea = br.readLine();
		}
		
		br.close();
		return listaMenu;
	}
	
	private static List<comboMod> cargarCombos(String nArchivo) throws FileNotFoundException, IOException
	{
		List<comboMod> listaCombos = new ArrayList<>();
		
		BufferedReader br=new BufferedReader(new FileReader(nArchivo));
		String linea=br.readLine();
		while (linea!=null) 
		{
			String[] parte=linea.split(";");
			String nombreCombo=parte[0];
			int desc=Integer.parseInt(parte[1].replace("%", ""));
			
			comboMod comboModificado = new comboMod(nombreCombo,desc);
			
			String producto1Menu=parte[2];
			String producto2Menu=parte[3];
			
			List<productoMenu>menu=restaurante.getMenuBase();
			
			for (productoMenu productoMenu : menu)
			{
				if (productoMenu.getNombre().equals(producto1Menu) |productoMenu.getNombre().equals(producto2Menu))
				{
					comboModificado.agregarItemACombo(productoMenu);
				}
			}
			
			listaCombos.add(comboModificado);
			linea=br.readLine(); 
		}
		br.close();
		
		return listaCombos;
	}
	
	public static void IniciarPedido(String nombreCliente,String direccionCliente)
	{
		ventas pedidoOrden=new ventas(nombreCliente,direccionCliente);
		ventaCurso=pedidoOrden;
	}
	
	public static ventas getPedidoEnCurso()
	{
		return ventaCurso;
	}
	
	
	public static String ConsultarPedido(int idPedido) throws FileNotFoundException, IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader("./data/" + String.valueOf(idPedido) + ".txt"));
		String linea=br.readLine();
		String factura="";
		while (linea!=null)
		{
			factura+=linea + "\n";
			
			linea=br.readLine();
		}
		
		System.out.println("Su pedido es:");
		
		ventas pedidoSolic=pedidos.get(String.valueOf(idPedido));
		String textoVentas=pedidoSolic.generarFacturaTexto();
		System.out.println(textoVentas);
		br.close();
		return factura;
	}
	
	private static List<bebida> cargarBebidas(String nombreArchivo) throws FileNotFoundException, IOException
	{
		List<bebida> listaBebidas=new ArrayList<>();
		
		BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
		String linea=br.readLine();
		while (linea!=null) 
		{
			String[] parte=linea.split(";");
			String nombreBebida=parte[0];
			int precioBebida = Integer.parseInt(parte[1].replace("%", ""));
			int pcaloriasBebida = Integer.parseInt(parte[2]);
			bebida bebida = new bebida(nombreBebida,precioBebida,pcaloriasBebida);
			listaBebidas.add(bebida);
			linea=br.readLine();
		}
		br.close();
		return listaBebidas;
	}
}
