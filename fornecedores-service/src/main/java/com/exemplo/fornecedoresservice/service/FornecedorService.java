package com.exemplo.fornecedoresservice.service;

import com.exemplo.fornecedoresservice.client.ProdutoClient;
import com.exemplo.fornecedoresservice.dto.ProdutoDTO;
import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final ProdutoClient produtoClient;

    public FornecedorService(FornecedorRepository fornecedorRepository, ProdutoClient produtoClient) {
        this.fornecedorRepository = fornecedorRepository;
        this.produtoClient = produtoClient;
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        if (fornecedorRepository.existsByCnpj(fornecedor.getCnpj())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "cnpj ja cadastrado");
        }
        // ignora id vindo no json para nao sobrescrever um registro existente
        fornecedor.setId(null);
        return fornecedorRepository.save(fornecedor);
    }

    public List<ProdutoDTO> listarProdutos() {
        try {
            return produtoClient.listarTodos();
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "produtos-service indisponivel");
        }
    }
}
