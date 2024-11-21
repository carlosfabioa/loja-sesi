package com.senai.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
