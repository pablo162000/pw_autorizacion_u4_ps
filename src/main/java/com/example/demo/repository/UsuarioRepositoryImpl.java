package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Usuario;

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
