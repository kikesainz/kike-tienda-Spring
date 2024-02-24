package com.kike.tienda.negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import com.kike.tienda.entities.User;
import com.kike.tienda.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
	private  UserRepository userRepository;

 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

		//Objeto User de Spring
		org.springframework.security.core.userdetails.User springUser=null;
		

			
			List<String> roles = user.getRoles();
//			GrantedAuthority es una interfaz en Spring que representa una autorización o permiso
//			En este paso recogemos todos los permisos del usuario en cuestión
			Set<GrantedAuthority> ga = new HashSet<>();
			for(String role:roles) {
				ga.add(new SimpleGrantedAuthority(role));
			}
			
			springUser = new org.springframework.security.core.userdetails.User(
							user.getEmail(),
							user.getPassword(),
							ga );	
		return springUser;
    }
}
