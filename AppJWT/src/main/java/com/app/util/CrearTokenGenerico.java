package com.app.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Base64Utils;

import com.app.model.entity.Usuario;

public class CrearTokenGenerico {
	  public static final String SECRET = Base64Utils.encodeToString("Alguna.Clave.Secreta.12345".getBytes());
	  
	  public static final long EXPIRATION_DATE_RESET_PASSWORD = 14000000L;
	  
	  public static final String TOKEN_PREFIX = "Bearer ";
	  
	  public static final String HEADER_STRING = "Authorization";
	  
	  public static final String CLAIMS_AUTHORITIES = "authorities";

	public static String getToken(Usuario usuario) throws IOException {
	    String username = usuario.getId() + "|" + usuario.getEmail() + "|" + usuario.getNombreApellido();
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    for (String role : ConvertirEnLista.getListaAuthority(usuario.getIdTipoUsuario().getNombre()))
	      authorities.add(new SimpleGrantedAuthority(role)); 
	    /*Claims claims = Jwts.claims();
	    claims.put("authorities", (new ObjectMapper()).writeValueAsString(authorities));
	    System.out.println("claims " + claims);
	    String token = Jwts.builder().setClaims(claims).setSubject(username).signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 14000000L)).compact();
	    return token;*/
	    return "";
	  }
}
