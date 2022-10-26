/**
 * 
 */
package com.zone.david.projectjpa.dao;

import java.util.List;

import com.zone.david.projectjpa.entity.SubGenero;

/**
 * @author david ZoNe
 * Interfaz DAO que realiza el CRUD con JPA patra la tabla subgenero.
 *
 */
public interface SubGeneroDAO {
	
	/**
	 * Metodo que permite guardar un subgenero
	 * @param subgenero {@link SubGenero} objeto a gusrdar.
	 */
	void guardar(SubGenero subgenero);
	
	/**
	 * Metodo que permite actualizar un subgenero
	 * @param subgenero {@link SubGenero} objeto a gusrdar.
	 */
	void actualizar(SubGenero subgenero);
	
	/**
	 * Metodo que permite eliminar un subgenero por su identificador
	 * @param id {@link Long} identificador del subgenero a elimianr.
	 */
	void eliminar(Long id);
	
	/**
	 * Metodo que permite consultar la lista de subgeneros.
	 * @return {@link List} Lista de subgeneros consultados.
	 */
	List<SubGenero>consultar();
	
	/**
	 * Metodo que permite consultar un subgenero a partir de su 8dentificador
	 * @param id {@link Long} identificador del subgenero a consultar.
	 * @return {@link SubGenero} objeto subgenero consultado
	 */
	SubGenero consultarById(Long id);

}
