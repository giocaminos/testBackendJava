package com.app.model.service;

import java.util.List;

import com.app.model.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();	
	public Usuario findOne(Integer id);
	public Usuario findOneEmail(String email);
	public List<Usuario> email(String email);
	public List<Usuario> findEmail(String email);
	public Usuario findAllData(String email);
	public Usuario save(Usuario entity);
	public void delete(Integer id);
}
