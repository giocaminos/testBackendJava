package com.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.model.entity.Log;


public interface ILogDao  extends CrudRepository<Log,Integer>{

}
