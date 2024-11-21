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

import com.senai.loja.model.Usuario;
import com.senai.loja.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

    @GetMapping("/login")
    public String exibirLogin() {
        return "usuario/login";
    }
	
	
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastro";
    }
	
    @PostMapping("/salvar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
    	usuarioService.salvarUsuario(usuario);
    	return "redirect:/usuarios/login";
    }	
    
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "usuario/lista";
	}
	
	@GetMapping("editar/{id}")
	public String editarUsuario(@PathVariable("id")  Long id, Model modelo) {
		Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(id);
		if(usuarioOpt.isPresent()) {
			modelo.addAttribute("usuario", usuarioOpt.get());
			return "usuario/cadastro";
		}else {
			return "redirect:/usuarios/listar";
		}
	}
	
	@GetMapping("/remover/{id}")
	public String removerUsuario(@PathVariable("id") Long id) {
		usuarioService.excluirUsuario(id);
		return "redirect:/usuarios/listar";
	}
}
