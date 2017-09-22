package com.afs.nats.stdapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.afs.nats.stdapp.service.AuthenticatedUserService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = AuthenticatedUserService.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//	        .withUser("user").password("user").roles("USER").and()
//	        .withUser("admin").password("admin").roles("USER", "ADMIN");
//	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// 	  http
	//           .authorizeRequests()
	//           .anyRequest()
	//           .authenticated()
	//           .and()
	//           .httpBasic();
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
//		http.headers().frameOptions().sameOrigin();
		
	    http.csrf().disable()
	        .authorizeRequests()
	        .antMatchers("/resources/**","/static/**","/css/**","/fonts/**","/js/**","/sass/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginPage("/login").permitAll()
	        .and()
	        .logout().permitAll();    
    
	}

    @Autowired
    public void globalSecurityConfiguration(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

// 	@Override
// 	public void configure(WebSecurity web) throws Exception {
// 	    web
// 	       .ignoring()
// 	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/h2-console/**");
// }

}
