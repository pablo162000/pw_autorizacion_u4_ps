package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager ;

	@Override
	public Usuario consultarPorUserName(String username) {
		// TODO Auto-generated method stub
		
		TypedQuery<Usuario>  myQuery = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.username=:datoUsername",Usuario.class);
		
		myQuery.setParameter("datoUsername", username);
		return myQuery.getSingleResult();
	}
	
	//consultar un token a partir de un objeto ususario to

}
