package com.senai.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.senai.loja.model.Produto;
import com.senai.loja.services.ProdutoService;

@Controller
public class HomeController {
	
	
	@Autowired
	private ProdutoService produtoService;

  @GetMapping
    public String exibirLogin() {
        return "usuario/login";
    }

	@GetMapping("/home")
	public String exibirPaginaInicial(Model model) {
	    List<Produto> produtos = produtoService.listar();
	    model.addAttribute("produtos", produtos);
	    return "home";
	}
}