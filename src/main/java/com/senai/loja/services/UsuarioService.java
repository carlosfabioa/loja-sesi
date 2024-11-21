package com.senai.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.loja.model.Role;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Usuario usuario = usuarioRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
	        return User.builder()
	                .username(usuario.getEmail())
	                .password(usuario.getSenha())
	                .roles(usuario.getRole().name())
	                .build();
	    }
	
	
	public Usuario salvarUsuario(Usuario usuario) {
	      if (usuario.getRole() == null) {
	            usuario.setRole(Role.USER);
	        }
	        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> buscarPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> buscarPorEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
	
	
	public void excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
}
