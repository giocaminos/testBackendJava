package com.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.dao.ITipoUsuarioDao;
import com.app.model.entity.TipoUsuario;
import com.app.model.service.ITipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {

	@Autowired
	private ITipoUsuarioDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuario> findAll() {		
		return (List<TipoUsuario>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoUsuario findOne(Integer id) {		
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(TipoUsuario entity) {		
		dao.save(entity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {		
		dao.deleteById(id);
	}

	@Override
	public TipoUsuario findOneByName(String name) {
		return dao.findOneByName(name);
	}

}
