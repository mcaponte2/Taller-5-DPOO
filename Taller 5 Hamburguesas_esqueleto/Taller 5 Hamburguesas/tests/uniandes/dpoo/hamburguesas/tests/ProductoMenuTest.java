package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
public class ProductoMenuTest {

	private ProductoMenu productoMenu1;

	@BeforeEach
	void setUp() throws Exception {
		productoMenu1 = new ProductoMenu("papas", 5000);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNombre() {
		assertEquals("papas", productoMenu1.getNombre(), "El nombre del ingrediente no es el esperado");
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(5000, productoMenu1.getPrecio(), "El precio no es el esperado");
	}
	
	@Test
	void testGenerarTextoFactura() {
		assertEquals("papas\n            5000\n", productoMenu1.generarTextoFactura(), "El texto en la factura no es el esperado");
	}
	
	
	
}
