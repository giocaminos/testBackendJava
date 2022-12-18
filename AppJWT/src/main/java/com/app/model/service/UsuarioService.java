package com.app.model.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.entity.Usuario;

@Service
public class UsuarioService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private IUsuarioService dao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = dao.findOneEmail(username);
		
		if(usuario == null) {
			logger.error("Error usuario no existe en el sistema");
			throw new UsernameNotFoundException("Error usuario no existe en el sistema");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		String[] array = usuario.getIdTipoUsuario().getNombre().split(",", -1);
		for(int i=0; i < array.length; i++) {
			logger.info("Role: "+array[i].toString());
			authorities.add(new SimpleGrantedAuthority(array[i].toString()));
		}		
		
		return  new User(usuario.getEmail(), usuario.getPassword(), true, true, true, true, authorities);

	}
}
