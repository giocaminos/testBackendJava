package com.app.model.service;

import java.util.List;

import com.app.model.entity.TipoUsuario;

public interface ITipoUsuarioService  {

	public List<TipoUsuario> findAll();	
	public TipoUsuario findOne(Integer id);
	public TipoUsuario findOneByName(String name);
	public void save(TipoUsuario entity);
	public void delete(Integer id);	
}
