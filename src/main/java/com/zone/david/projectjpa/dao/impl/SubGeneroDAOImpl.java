/**
 * 
 */
package com.zone.david.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.zone.david.projectjpa.dao.SubGeneroDAO;
import com.zone.david.projectjpa.entity.SubGenero;

/**
 * @author David ZoNe Clase que implementa el CRUD para las transacciones para
 *         la tabla de subgenero
 *
 */
public class SubGeneroDAOImpl implements SubGeneroDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDavid");

	@Override
	public void guardar(SubGenero subgenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(subgenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void actualizar(SubGenero subgenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(subgenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subgeneroConsultado = em.find(SubGenero.class, id);

		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(subgeneroConsultado);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<SubGenero> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		TypedQuery<SubGenero> queryTyped = (TypedQuery<SubGenero>) em
				.createQuery("FROM SubGenero ORDER BY descripcion");
		return queryTyped.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		return em.find(SubGenero.class, id);
		
	}

}
