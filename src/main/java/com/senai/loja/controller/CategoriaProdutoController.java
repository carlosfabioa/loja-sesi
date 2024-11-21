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
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.CategoriaProdutoRepository;
import com.senai.loja.services.CategoriaProdutoService;
import com.senai.loja.services.UsuarioService;

@Controller
@RequestMapping("/categorias")
public class CategoriaProdutoController {
	
	@Autowired
	private CategoriaProdutoService categoriaService;
	
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("categoria", new CategoriaProduto());
        return "categoria/cadastro";
    }
	
    @PostMapping("/salvar")
    public String cadastrar(@ModelAttribute CategoriaProduto categoria) {
    	categoriaService.salvar(categoria);
    	return "redirect:/categorias/listar";
    }	
    
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("categorias", categoriaService.listar());
		return "categoria/lista";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id")  Long id, Model modelo) {
		Optional<CategoriaProduto> categoriaOpt = categoriaService.buscarPorId(id);
		if(categoriaOpt.isPresent()) {
			modelo.addAttribute("categoria", categoriaOpt.get());
			return "categoria/cadastro";
		}else {
			return "redirect:/categorias/listar";
		}
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Long id) {
		categoriaService.excluir(id);
		return "redirect:/categorias/listar";
	}
}
