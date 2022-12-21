package com.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.dao.ILogDao;
import com.app.model.entity.Log;
import com.app.model.service.ILogService;

@Service
public class LogServiceImpl  implements ILogService {
	
	@Autowired
	private ILogDao dao;

	@Override
	public List<Log> findAll() {
		return (List<Log>) dao.findByOrderByIdDesc();
	}

	@Override
	public void save(Log entity) {
		dao.save(entity);		
	}

}
