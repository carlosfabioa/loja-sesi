package com.senai.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.senai.loja.model.Carrinho;
import com.senai.loja.model.Produto;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.ProdutoRepository;
import com.senai.loja.services.ProdutoService;
import com.senai.loja.services.UsuarioService;
import com.senai.loja.services.carrinhoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private carrinhoService carrinhoService;
	
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;
	
	@GetMapping
	public String exibirCarrinho(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailUsuarioLogado = authentication.getName();

        Usuario usuarioLogado = usuarioService.buscarPorEmail(emailUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Carrinho> itensCarrinho = carrinhoService.listarCarrinhoDoUsuario(usuarioLogado);
        double totalCarrinho = carrinhoService.calcularTotalCarrinho(usuarioLogado);

        model.addAttribute("itensCarrinho", itensCarrinho);
        model.addAttribute("totalCarrinho", totalCarrinho);

        return "carrinho/gerenciar";
	}
	
	@GetMapping("/produtos")
	public String listarProdutos(Model model) {
	    List<Produto> produtos = produtoService.listar();
	    Long clienteId = 1L; 
	    model.addAttribute("produtos", produtos);
	    model.addAttribute("clienteId", clienteId);
	    return "carrinho/produtos";
	}
	
    @PostMapping("/adicionar")
    public String adicionarProduto(@RequestParam Long produtoId, @RequestParam int quantidade) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailUsuarioLogado = authentication.getName();

        Usuario usuarioLogado = usuarioService.buscarPorEmail(emailUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Produto produto = produtoService.buscarPorId(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        carrinhoService.adicionarAoCarrinho(usuarioLogado, produto, quantidade);

        return "redirect:/carrinho";
    }
    
    @PostMapping("/atualizar")
    public String atualizarQuantidade(@RequestParam Long carrinhoId, @RequestParam int quantidade) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailUsuarioLogado = authentication.getName();

        Usuario usuarioLogado = usuarioService.buscarPorEmail(emailUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        carrinhoService.atualizarQuantidade(carrinhoId, quantidade);

        return "redirect:/carrinho";
    }
	
    @PostMapping("/remover")
    public String removerProduto(@RequestParam Long carrinhoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailUsuarioLogado = authentication.getName();

        Usuario usuarioLogado = usuarioService.buscarPorEmail(emailUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        carrinhoService.removerDoCarrinho(carrinhoId);

        return "redirect:/carrinho";
    }
}
