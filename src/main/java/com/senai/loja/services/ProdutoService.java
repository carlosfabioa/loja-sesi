package com.senai.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.loja.model.CategoriaProduto;
import com.senai.loja.model.Produto;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.CategoriaProdutoRepository;
import com.senai.loja.repository.ProdutoRepository;
import com.senai.loja.repository.UsuarioRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscarPorId(Long id){
		return produtoRepository.findById(id);
	}
	
	public void excluir(Long id) {
		produtoRepository.deleteById(id);
	}
	
	
}
