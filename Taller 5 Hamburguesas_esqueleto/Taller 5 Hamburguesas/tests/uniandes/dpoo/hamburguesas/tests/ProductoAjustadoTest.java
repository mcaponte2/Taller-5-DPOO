package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;


public class ProductoAjustadoTest {

	private ProductoAjustado productoAjustado1;
	private ProductoMenu productoMenu1;
	private Ingrediente ingredienteAgregado;
	private Ingrediente ingredienteEliminado;
	
	@BeforeEach
	void setUp() throws Exception {
		productoMenu1 = new ProductoMenu("papas", 5000);
		productoAjustado1 = new ProductoAjustado(productoMenu1);
		ingredienteAgregado = new Ingrediente("queso", 200);
		ingredienteEliminado = new Ingrediente("tocineta", 0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNombre() {
		assertEquals("papas", productoAjustado1.getNombre(), "El nombre del producto no es el esperado");
	}

	@Test
	void testGetPrecio() {
		productoAjustado1.getAgregados().add(ingredienteAgregado);
		assertEquals(5200, productoAjustado1.getPrecio(), "El precio del producto no es el esperado");
	}
	
	@Test
	void testGenerarTextoFactura() {
		productoAjustado1.getAgregados().add(ingredienteAgregado);
		productoAjustado1.getEliminados().add(ingredienteEliminado);
		assertEquals(("papas"+"    +queso                200" +"    -tocineta" +"            5200\n"), productoAjustado1.generarTextoFactura());
	}
}
