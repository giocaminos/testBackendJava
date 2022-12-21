package com.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.entity.Log;

public interface ILogDao extends JpaRepository<Log, Integer> {

	List<Log> findByOrderByIdDesc();
}
