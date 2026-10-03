package com.exemplo.fornecedoresservice.dto;

import java.math.BigDecimal;

// so os campos que o produtos-service devolve
public record ProdutoDTO(Long id, String nome, BigDecimal preco) {
}
