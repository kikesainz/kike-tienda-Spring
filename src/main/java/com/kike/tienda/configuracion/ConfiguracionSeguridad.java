package com.kike.tienda.configuracion;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity (debug=true)
public class ConfiguracionSeguridad {
	
	@Autowired
	private UserDetailsService userDetailsService; //Inyectamos la clase UserService que acabamos de crear

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        //Evitamos que al redirigir nos añada un query param en la url
        requestCache.setMatchingRequestParameterName(null);
    	
    	http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/css/**", "/resources/**", "/", "/index").permitAll()
                    .requestMatchers("/obtenercategorias").permitAll()
                    .requestMatchers("/insertarcategorias").permitAll()
                    .requestMatchers("/formularioactualizarcategorias").hasAuthority("ENCARGADO")
                    .requestMatchers("/pedidos/listarpedidos").hasAnyAuthority("ADMIN","ENCARGADO")    
                    .requestMatchers("/peticiones/listarpeticiones").hasAnyAuthority("ADMIN","ENCARGADO") 
                    .anyRequest().authenticated()
                    
            )
            .formLogin(formLogin ->
                formLogin
                	.defaultSuccessUrl("/", true) //Dónde nos llevará tras logarnos con éxito
//                    .loginPage("/login")
                    .permitAll()
            )
            .logout(logout ->
                logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").deleteCookies("JSESSIONID")
            )
            .requestCache((cache) -> cache
                    .requestCache(requestCache)
                    
            )
    		.authenticationProvider(authenticationProvider()) //Utilizamos el authenticationProvider que definimos más abajo.
    		.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfiguration()))
            .csrf(AbstractHttpConfigurer::disable);
//    		.csrf(csrf ->csrf.disable()); //Deshabilitar el CORS.
//    		.exceptionHandling((exceptionHandling) -> exceptionHandling.accessDeniedPage("/accesoDenegado")); //Si quisiéramos redirigir a una página "bonita" para informar que el usuario no tiene permisos

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	  @Bean
	  public CorsConfigurationSource corsConfiguration() {
	    return request -> {
	      org.springframework.web.cors.CorsConfiguration config = 
	          new org.springframework.web.cors.CorsConfiguration();
	      config.setAllowedHeaders(Collections.singletonList("*"));
	      config.setAllowedMethods(Collections.singletonList("*"));
	      config.setAllowedOriginPatterns(Collections.singletonList("*"));
	      config.setAllowCredentials(true);
	      return config;
	    };
	  }
}
