package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@CrossOrigin("http://localhost:4200")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().cors()
		.and()
		.authorizeRequests()
		
		
		//configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		
		
		
		
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers("/restaurant/*").permitAll()
		//.antMatchers("/generatedata").permitAll()
		.antMatchers("restaurant/findRestaurant/**").permitAll()
		.antMatchers("restaurant/getmenu/**").permitAll()
		.antMatchers("/customer/*").permitAll()

		//.anyRequest().authenticated()
		
		.and().httpBasic();
		

		
		//http.headers();
		
		
		//.frameOptions().sameOrigin()
		//.httpStrictTransportSecurity().disable();
		
	}
	
	
	
	
	@Override
	 public void configure(WebSecurity webSecurity) throws Exception
	   {
	     webSecurity
	    .ignoring();
	        // All of Spring Security will ignore the requests
	    	//.antMatchers (HttpMethod.GET)
	    	//.antMatchers( HttpMethod.OPTIONS, "/**" );
	        //.antMatchers("/restaurant/findRestaurant/**")
	        //.antMatchers("/restaurant/getmenu/**");
	        //.antMatchers("/restaurant/cancel/**");
	     	
	     //webSecurity.cors();
	     }
	
	 /*  @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200/auth/login"));
	        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	*/
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
		
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
	}
	
	
}
