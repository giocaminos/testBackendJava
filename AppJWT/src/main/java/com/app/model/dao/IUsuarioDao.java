package com.app.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario,Integer> {

	@Query(value = "SELECT * FROM usuario u WHERE u.email = ?1", nativeQuery = true)
	Usuario findByOneEmail(String email);
	
}
