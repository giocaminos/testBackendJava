package com.app.model.service;

import java.util.List;

import com.app.model.entity.Log;

public interface ILogService {

	public List<Log> findAll();	
	public void save(Log entity);
}
