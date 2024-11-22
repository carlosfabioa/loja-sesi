package com.senai.loja.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> buscarPorId(Long id) {
		return produtoRepository.findById(id);
	}

	public void excluir(Long id) {
		produtoRepository.deleteById(id);
	}

	public void salvarComImagem(Produto produto, MultipartFile foto) {
		try {
			if (!foto.isEmpty()) {
				String uploadDir = "images/";
				String fileName = foto.getOriginalFilename();
				Path filePath = Paths.get(uploadDir + fileName);
				Files.createDirectories(filePath.getParent());
				Files.copy(foto.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				produto.setFoto("/" + uploadDir + fileName);
			}
			produtoRepository.save(produto);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao salvar imagem: " + e.getMessage());
		}
	}

}
