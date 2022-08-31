package com.pedroapp.crm.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.pedroapp.crm.model.Usuario;
import com.pedroapp.crm.repository.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = userRepository.findByEmail(username);
			if(usuario.isPresent()) {
				return usuario.get();
	}
		 
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
