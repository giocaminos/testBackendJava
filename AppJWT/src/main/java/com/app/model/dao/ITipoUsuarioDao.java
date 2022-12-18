package com.app.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.model.entity.TipoUsuario;

public interface ITipoUsuarioDao extends CrudRepository<TipoUsuario, Integer> {

	@Query(value="SELECT t FROM TipoUsuario t WHERE t.nombre = ?1")
	public TipoUsuario findOneByName (String name);
}
