package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	
	private Pedido pedido1;
	private Producto producto1;
	private Producto producto2;

	@BeforeEach
	void setUp() throws Exception {
		pedido1= new Pedido("Marjorie", "calle 1#10-20");
		producto1= new ProductoMenu("hamburguesa", 20000);
		producto2= new ProductoMenu("papas", 5000);
		ArrayList<Producto> productosPedido=new ArrayList<>();
		productosPedido.add(producto1);
		productosPedido.add(producto2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdPedido() {
		assertEquals(3, pedido1.getIdPedido());
	}
	
	@Test
	void testGetNombreCliente() {
		assertEquals("Marjorie", pedido1.getNombreCliente(), "El nombre del cliente del pedido no es el esperado");
	}
	
	@Test
	void testGetDireccionCliente() {
		assertEquals("calle 1#10-20", pedido1.getDireccionCliente(), "La dirección del cliente del pedido no es la esperada");
	}
	
	@Test
	void testAgregarProducto() {
		pedido1.agregarProducto(producto1);
		pedido1.agregarProducto(producto2);
		assertEquals(2, pedido1.productos.size());
		assertEquals(producto1, pedido1.productos.get(0));
		assertEquals(producto2, pedido1.productos.get(1));
	}
	
	@Test
	void testGetPrecioNetoPedido() {
		pedido1.agregarProducto(producto1);
		pedido1.agregarProducto(producto2);
		assertEquals(29750.0, pedido1.getPrecioTotalPedido(), "El precio total del pedido no es el esperado");
	}
	
	@Test
	void testGenerarTextoFactura() {
		pedido1.agregarProducto(producto1);
		pedido1.agregarProducto(producto2);
		String textoFactura= ("Cliente: "+"Marjorie"+"\n"+"Dirección: "+"calle 1#10-20"+"\n"+"----------------\n"+"hamburguesa"+"\n"+"            "+"20000"+"\n"+"papas"+"\n"+"            "+"5000"+"\n"+"----------------\n"+"Precio Neto:  "+"25000"+"\n"+"IVA:          "+"4750"+"\n"+"Precio Total: "+"29750"+"\n");
		assertEquals(textoFactura, pedido1.generarTextoFactura(),"El texto en la factura no es ele esperado");
	}
}
