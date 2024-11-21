package com.senai.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.loja.model.Carrinho;
import com.senai.loja.model.Usuario;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
    List<Carrinho> findByUsuario(Usuario usuario);
    Carrinho findByUsuarioAndProdutoId(Usuario usuario, Long produtoId);
}
