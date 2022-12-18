package com.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.dao.IUsuarioDao;
import com.app.model.entity.Usuario;
import com.app.model.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {		
		return (List<Usuario>) dao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario entity) {		
		return dao.save(entity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {		
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Integer id) {		
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOneEmail(String email) {		
		return dao.findByOneEmail(email);
	}

	@Override
	public List<Usuario> email(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findAllData(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}
