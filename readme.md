# Documentação Microserviços
https://claude.ai/code/artifact/2c541174-0b49-486d-9ee2-1682e91b8daf

# Documentação implementação Docker GUIA
https://claude.ai/code/artifact/a5f3c8e5-81de-4791-a16c-a71d4aa45f0f

# Documentação implementação Kubernetes GUIA
https://claude.ai/code/artifact/68cd2944-af3d-430f-8e6f-ea27c4186982

# Documentação deploy na Oracle Cloud GUIA
https://claude.ai/artifact/71fuEpCrAzrZzCS6kyVzKo

# Documentação GitHub Actions (CI/CD) GUIA
https://claude.ai/artifact/F21uNn1PE4FpN3ewMj6Aw6

# Aluno
Victor Griggi Moreira Regis da Silva

# fornecedores-service

Novo microsserviço criado a partir do clientes-service. Roda na porta 8084, usa H2 em memória, se registra no Eureka e pega a configuração do config-server (config-repo/fornecedores-service.properties). Quando sobe, já cadastra cinco fornecedores.

Endpoints:

- GET /fornecedores
- GET /fornecedores/{id} (404 se não existir)
- POST /fornecedores (201 com o fornecedor criado, 409 se o CNPJ já existir)
- GET /fornecedores/produtos (lista os produtos do produtos-service via Feign)

Pelo gateway o caminho fica http://localhost:8085/fornecedores-service/fornecedores. Como o gateway exige token, antes é preciso cadastrar um usuário em /auth-service/usuarios, fazer login em /auth-service/usuarios/login e mandar o token no header Authorization: Bearer.

O auth-service foi movido da porta 8084 para a 8086 para liberar a 8084 para este serviço.

No docker-compose, o config-server ganhou um healthcheck e os serviços só sobem depois que ele responde. Antes eles subiam antes da configuração estar disponível e caíam na porta 8080.
