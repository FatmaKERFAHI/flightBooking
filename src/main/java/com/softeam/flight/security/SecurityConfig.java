package com.softeam.flight.security;


import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


// TODO: Auto-generated Javadoc
/**
 *  @author Mosbah Mohamed Ali
 * The Class SecurityConfig.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequestMapping(produces = "application/json")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Password encoder.
	 *
	 * @return the no op password encoder
	 */
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	//si l'on souhaite encoder le mot de pass
	/*@Bean
	public PasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	}*/

	/**
	 * Configure.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().formLogin().loginProcessingUrl("/login") //permet de generer une page de login au lieu d'une popup est donc gerer les cas d'erreur ou de succes
				.successHandler(new AuthentificationLoginSuccessHandler())
				.failureHandler(new AuthentificationLoginSFailureHandler()).and().authorizeRequests().antMatchers("/login","/adduser","/flight/addflight","/flight/searchAll","/flight/dropflight/{idFlight}")
				 .permitAll().anyRequest()
				.fullyAuthenticated();
		http.csrf().disable();


	}
	
	/**
	 * The Class AuthentificationLoginSuccessHandler.
	 */
	//renvoie un statut 200 si login est un succes (cela nous permet de recuperer le statut en React)
	private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
		
		/**
		 * On authentication success.
		 *
		 * @param request the request
		 * @param response the response
		 * @param authentication the authentication
		 * @throws IOException Signals that an I/O exception has occurred.
		 * @throws ServletException the servlet exception
		 */
		@SuppressWarnings("unused")
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws IOException, ServletException {
			response.setStatus(HttpServletResponse.SC_OK);
			
			
		}
	}
	
	/**
	 * The Class AuthentificationLoginSFailureHandler.
	 */
	//renvoie un statut 403 si le login est failed
	private class AuthentificationLoginSFailureHandler implements AuthenticationFailureHandler {
		
		/**
		 * On authentication failure.
		 *
		 * @param request the request
		 * @param response the response
		 * @param exception the exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 * @throws ServletException the servlet exception
		 */
		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				org.springframework.security.core.AuthenticationException exception)
				throws IOException, ServletException {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			System.out.println("failed");
			System.out.println(response);
			
		}
	}
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.cors().and().authorizeRequests().antMatchers("/getallpassengers",
	 * "/getpassengers/{id}","/addpassengers","/deletepassengers/{id}","/adduser").
	 * permitAll().anyRequest().fullyAuthenticated(); http.httpBasic();
	 * http.csrf().disable(); }
	 */

	/**
	 * Cors configuration source.
	 *
	 * @return the cors configuration source
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return (CorsConfigurationSource) source;
	}

}
