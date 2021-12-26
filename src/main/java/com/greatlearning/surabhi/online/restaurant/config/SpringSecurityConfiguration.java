package com.greatlearning.surabhi.online.restaurant.config;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// JDBC authentication, method chaining
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.withUsername("arpitha").password(getPasswordEncoder().encode("arpitha"))
						.roles("ONLINE_ADMIN"))
				.withUser(
						User.withUsername("girish").password(getPasswordEncoder().encode("girish")).roles("ONLINE_USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().
		antMatchers("/register").hasRole("ONLINE_USER").
		antMatchers("/surabhi/userCrudOperations/*","/admin/*").hasRole("ONLINE_ADMIN")
		.antMatchers("/surabhi/viewAllItems/").hasAnyRole("ONLINE_ADMIN,ONLINE_USER")
		.antMatchers("/").permitAll()
		.and()
		.formLogin();/* and().logout().logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll().logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
        .invalidateHttpSession(true);*/
		/*http.csrf().disable()
		.authorizeRequests().antMatchers("/logout").logout(logout -> logout
                .permitAll()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            ).permitAll().and().logout()
                .logoutSuccessUrl("/logout");*/
		http.headers().frameOptions().disable();
		
			}

//	If you don't want to encode the created password, you can write the below bean method, FYI: not recommended for Prod env
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}
}
