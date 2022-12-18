package com.app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)//se habilita para poder tener acceso a las rutas por medio de roles con anotacion en el controlador rest
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired//buscara una clase en el contexto de spring si existe y la inyectara, ya que UserDetailService esta con anotacion service para que spring lo reonozca, clase 15 video #7
	private UserDetailsService usuarioService;

	@Bean//se registra en el contexto de spring y se anota con Bean ya que es un metodo  para que se pueda utilizar globalmente, la difeencia entre Component y Bean que Componente es para anotar una clase y Bean para metodo
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}
	
	@Bean("authenticationManager")
	@Override	
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}	
	//es para el lado de spring, seguridad de proteccion, clase 15 video #10 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
