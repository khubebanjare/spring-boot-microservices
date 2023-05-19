package com.khube.spring.security.main.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
public class SpringSecurityServiceOldConfigure extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// normal user creation
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth .inMemoryAuthentication() .withUser("khube")
	 * .password("khube007") .roles("admin");
	 * 
	 * auth .inMemoryAuthentication() .withUser("ram") .password("ram")
	 * .roles("user"); }
	 */
	//$2a$10$T1VIVo1hDybHbwk2ubTON.KGfxA8TNwgZjzoUpgzqniy5LbQvxvRG
	
	// all class method implemented for security
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .anyRequest() .fullyAuthenticated() .and() .httpBasic();
	 * 
	 * http .csrf() .disable(); }
	 */
	
	// specific class and method related configuration
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .antMatchers("/auth/api/**") .fullyAuthenticated()
	 * .and() .httpBasic();
	 * 
	 * http .csrf() .disable(); }
	 */
	
	// roles based authentication
	
	// normal usre creation
	/*
	 * protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .antMatchers("/auth/api/**") .hasRole("admin")
	 * .anyRequest() .fullyAuthenticated() .and() .httpBasic();
	 * 
	 * http .csrf() .disable(); }
	 */}
