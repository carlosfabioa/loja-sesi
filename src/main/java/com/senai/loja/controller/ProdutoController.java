package com.senai.loja.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.loja.model.CategoriaProduto;
import com.senai.loja.model.Produto;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.CategoriaProdutoRepository;
import com.senai.loja.services.CategoriaProdutoService;
import com.senai.loja.services.ProdutoService;
import com.senai.loja.services.UsuarioService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaProdutoService categoriaService;
	
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
		model.addAttribute("categorias", categoriaService.listar());
        return "produto/cadastro";
    }
	
    @PostMapping("/salvar")
    public String cadastrar(@ModelAttribute Produto produto) {
    	produtoService.salvar(produto);
    	return "redirect:/produtos/listar";
    }	
    
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("produtos", produtoService.listar());
		return "produto/lista";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id")  Long id, Model modelo) {
		Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
		if(produtoOpt.isPresent()) {
			modelo.addAttribute("produto", produtoOpt.get());
			modelo.addAttribute("categorias", categoriaService.listar());
			return "produto/cadastro";
		}else {
			return "redirect:/produtos/listar";
		}
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Long id) {
		produtoService.excluir(id);
		return "redirect:/produtos/listar";
	}
}
