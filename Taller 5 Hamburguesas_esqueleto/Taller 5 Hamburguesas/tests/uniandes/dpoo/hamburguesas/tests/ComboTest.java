package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {

	private Combo combo1;
	private ProductoMenu productoMenu1;
	private ProductoMenu productoMenu2;
	
	@BeforeEach
	void setUp() throws Exception {
		productoMenu1= new ProductoMenu("hamburguesa", 20000);
		productoMenu2=new ProductoMenu("papas", 5000);
		ArrayList<ProductoMenu> itemsCombo= new ArrayList<>();
		itemsCombo.add(productoMenu1);
		itemsCombo.add(productoMenu2);
			
		combo1= new Combo("personal", 0.5, itemsCombo);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNombre() {
		assertEquals("personal", combo1.getNombre(), "El nombre del combo no es el esperado");
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(12500.0, combo1.getPrecio(), "El precio del combo no es el esperado");
	}
	@Test
	void testGenerarTextoFactura() {
		assertEquals(("Combo "+"personal"+"\n"+" Descuento: "+"0.5"+"\n"+"            "+"12500"+"\n"), combo1.generarTextoFactura());
	}
}
