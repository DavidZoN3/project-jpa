/**
 * 
 */
package com.zone.david.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.zone.david.projectjpa.dao.SubGeneroDAO;
import com.zone.david.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.zone.david.projectjpa.entity.Genero;
import com.zone.david.projectjpa.entity.SubGenero;

/**
 * @author David ZoNe Clase test para comprobar el funcionamiento de los metodos
 *         del CRUD de subgenro;
 *
 */
class SubGeneroDAOImplTest {

	private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for
	 * {@link com.zone.david.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.zone.david.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("HardCore");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);

		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);

		subGenero.setGenero(genero);

		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for
	 * {@link com.zone.david.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.zone.david.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(7L);
		subGeneroConsultado.setDescripcion("Trash Metal");
		subGeneroConsultado.getGenero().setDescripcion("Metal Trash");
		this.subGeneroDAO.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for
	 * {@link com.zone.david.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDAO.eliminar(7L);
	}

	/**
	 * Test method for
	 * {@link com.zone.david.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados = this.subGeneroDAO.consultar();

		assertTrue(subGenerosConsultados.size() > 0);

		for (SubGenero subgenero : subGenerosConsultados) {
			System.out.println("Subgenero: " + subgenero.getDescripcion());
			System.out.println("Genero: " + subgenero.getGenero().getDescripcion());
		}
	}

	/**
	 * Test method for
	 * {@link com.zone.david.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
