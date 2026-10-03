package com.exemplo.fornecedoresservice.client;

import com.exemplo.fornecedoresservice.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// o nome e resolvido pelo eureka, sem url fixa
@FeignClient(name = "produtos-service")
public interface ProdutoClient {

    @GetMapping("/produtos")
    List<ProdutoDTO> listarTodos();
}
