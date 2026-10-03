package com.exemplo.fornecedoresservice.config;

import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// popula o h2 com fornecedores de teste quando a aplicacao sobe
@Component
public class DataInitializer implements CommandLineRunner {

    private final FornecedorRepository fornecedorRepository;

    public DataInitializer(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void run(String... args) {
        fornecedorRepository.save(new Fornecedor("Distribuidora Alfa", "11.222.333/0001-81"));
        fornecedorRepository.save(new Fornecedor("Tech Pecas Ltda", "22.333.444/0001-05"));
        fornecedorRepository.save(new Fornecedor("Info Atacado", "33.444.555/0001-20"));
        fornecedorRepository.save(new Fornecedor("Mega Eletronicos", "44.555.666/0001-44"));
        fornecedorRepository.save(new Fornecedor("Norte Suprimentos", "55.666.777/0001-69"));
    }
}
