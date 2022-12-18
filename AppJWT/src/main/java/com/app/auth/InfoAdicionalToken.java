package com.app.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.app.model.entity.Usuario;
import com.app.model.service.IUsuarioService;

@Component//clase 15 video #14
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IUsuarioService service;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario u = service.findOneEmail(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("id", u.getId());
		info.put("nombre_apellido", u.getNombreApellido());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		System.out.println("authentication: "+authentication.toString());
		return accessToken;
	}

}
