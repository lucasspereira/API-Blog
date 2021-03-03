package com.lucaspereira.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucaspereira.meuBlog.model.ModelUsuario;
import com.lucaspereira.meuBlog.repository.RepositoryUsuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<ModelUsuario> user = repositoryUsuario.findByUsuario(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "not found."));
		
		return user.map(UserDetailsImpl::new).get();
	}

}
