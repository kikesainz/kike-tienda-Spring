package com.kike.tienda.configuracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
                    .requestMatchers("/formularioactualizarcategorias").hasAnyRole("ENCARGADO")
                    .requestMatchers("/pedidos/listarpedidos").hasAnyRole("ADMIN","ENCARGADO")          
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
                    
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
