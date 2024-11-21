package com.senai.loja.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.senai.loja.model.Carrinho;
import com.senai.loja.model.CategoriaProduto;
import com.senai.loja.model.Endereco;
import com.senai.loja.model.Produto;
import com.senai.loja.model.Role;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.CarrinhoRepository;
import com.senai.loja.repository.CategoriaProdutoRepository;
import com.senai.loja.repository.EnderecoRepository;
import com.senai.loja.repository.ProdutoRepository;
import com.senai.loja.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Bean
	CommandLineRunner executar() {
		
		return args ->{
			Usuario usuario = new Usuario();
			usuario.setNome("admin");
			usuario.setEmail("admin@example.com");
			usuario.setSenha(new BCryptPasswordEncoder().encode("admin"));
			usuario.setRole(Role.ADMIN);
			usuarioRepository.save(usuario);
			
			Usuario usuario1 = new Usuario();
			usuario1.setNome("maria");
			usuario1.setEmail("maria@example.com");
			usuario1.setSenha(new BCryptPasswordEncoder().encode("maria"));
			usuario1.setRole(Role.USER);
			
			usuarioRepository.save(usuario1);
			
			
			Endereco endereco = new Endereco();
			endereco.setRua("Rua Rio das Antas");
			endereco.setNumero(16);
			endereco.setBairro("Jardim Tropical");
			endereco.setCidade("Maringá");
			endereco.setEstado("PR");
			endereco.setCep("87100-040");
			endereco.setUsuario(usuario);
			
			enderecoRepository.save(endereco);
			
			Endereco endereco1 = new Endereco();
			endereco1.setRua("Rua Madeira");
			endereco1.setNumero(36);
			endereco1.setBairro("Residencial Tuiuti");
			endereco1.setCidade("Maringá");
			endereco1.setEstado("PR");
			endereco1.setCep("87090-040");
			endereco1.setUsuario(usuario);
			
			enderecoRepository.save(endereco1);
			
			
			CategoriaProduto categoria = new CategoriaProduto();
			categoria.setNome("eletronicos");
			categoriaProdutoRepository.save(categoria);
			
			CategoriaProduto categoria1 = new CategoriaProduto();
			categoria1.setNome("papelaria");
			categoriaProdutoRepository.save(categoria1);

			CategoriaProduto categoria2 = new CategoriaProduto();
			categoria2.setNome("vestuario");
			categoriaProdutoRepository.save(categoria2);
			
			
			Produto produto = new Produto();
			produto.setNome("televisão");
			produto.setDescricao("televisao de 50 polegadas");
			produto.setPreco(2500.00);
			produto.setCategoria(categoria);
			produto.setFoto("https://wx.mlcdn.com.br/ponzi/production/portaldalu/31726_01.jpg");
			produtoRepository.save(produto);
			
			Produto produto1 = new Produto();
			produto1.setNome("lapis B2");
			produto1.setDescricao("lapis para desenho B2 - Fabber");
			produto1.setPreco(5.00);
			produto1.setCategoria(categoria1);
			produto1.setFoto("https://casadaarte.vtexassets.com/arquivos/ids/209198/9002B.jpg?v=638653041912900000");
			produtoRepository.save(produto1);
			
			Produto produto2 = new Produto();
			produto2.setNome("Caderno espiral");
			produto2.setDescricao("caderno animado");
			produto2.setPreco(25.00);
			produto2.setCategoria(categoria1);
			produto2.setFoto("https://cdn.awsli.com.br/300x300/2633/2633201/produto/237775757/caderno-10-materias-flork-jandaia-160fls--3--ro60j2jeaq.png");
			produtoRepository.save(produto2);
			
			
			
			Carrinho item = new Carrinho();
			item.setUsuario(usuario);
			item.setProduto(produto);
			item.setQuantidade(10);
			carrinhoRepository.save(item);

			Carrinho item1 = new Carrinho();
			item1.setUsuario(usuario);
			item1.setProduto(produto1);
			item1.setQuantidade(9);
			carrinhoRepository.save(item1);

			Carrinho item2 = new Carrinho();
			item2.setUsuario(usuario1);
			item2.setProduto(produto1);
			item2.setQuantidade(8);
			carrinhoRepository.save(item2);
		};
	}
}
