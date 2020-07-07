package com.baeldung.lss.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class LssSecurityConfig extends WebSecurityConfigurerAdapter {

  

    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http
		.authorizeRequests()			
			.antMatchers("/delete/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin().and()
		.httpBasic();
	}

    
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.
			inMemoryAuthentication().
			withUser("user").password("pass").roles("USER");
	}

//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off 
//        auth.
//            inMemoryAuthentication().
//            withUser("user").password("pass").roles("USER");
//    } // @formatter:on
    
    

}
