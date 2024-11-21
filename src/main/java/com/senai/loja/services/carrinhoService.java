package com.senai.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.loja.model.Carrinho;
import com.senai.loja.model.Produto;
import com.senai.loja.model.Usuario;
import com.senai.loja.repository.CarrinhoRepository;

@Service
public class carrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public List<Carrinho> listarCarrinhoDoUsuario(Usuario usuario){
		return carrinhoRepository.findByUsuario(usuario);
	}
	
	public double calcularTotalCarrinho(Usuario usuario) {
		List<Carrinho> itensCarrinho = listarCarrinhoDoUsuario(usuario);
		return itensCarrinho.stream()
				.mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade())
				.sum();
	}
	
    public void adicionarAoCarrinho(Usuario usuario, Produto produto, int quantidade) {
        Carrinho itemExistente = carrinhoRepository.findByUsuarioAndProdutoId(usuario, produto.getId());
        if (itemExistente != null) {
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
            carrinhoRepository.save(itemExistente);
        } else {
            Carrinho novoItem = new Carrinho();
            novoItem.setUsuario(usuario);
            novoItem.setProduto(produto);
            novoItem.setQuantidade(quantidade);
            carrinhoRepository.save(novoItem);
        }
    }	

    public void atualizarQuantidade(Long carrinhoId, int novaQuantidade) {
        Carrinho item = carrinhoRepository.findById(carrinhoId).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        item.setQuantidade(novaQuantidade);
        carrinhoRepository.save(item);
    }
	 
    public void removerDoCarrinho(Long carrinhoId) {
        carrinhoRepository.deleteById(carrinhoId);
    }
}
