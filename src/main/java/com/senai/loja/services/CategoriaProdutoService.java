package com.senai.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.loja.model.CategoriaProduto;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.CategoriaProdutoRepository;
import com.senai.loja.repository.UsuarioRepository;

@Service
public class CategoriaProdutoService {
	@Autowired
	private CategoriaProdutoRepository categoriaRepository;
	
	public CategoriaProduto salvar(CategoriaProduto categoria) {
		return categoriaRepository.save(categoria);
	}
	
	
	public List<CategoriaProduto> listar(){
		return categoriaRepository.findAll();
	}
	
	public Optional<CategoriaProduto> buscarPorId(Long id){
		return categoriaRepository.findById(id);
	}
	
	public void excluir(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	
}
