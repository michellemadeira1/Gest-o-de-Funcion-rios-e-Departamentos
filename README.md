# Cadastro de Funcionários e Departamentos

Este projeto tem como objetivo o gerenciamento de funcionários e departamentos dentro de uma organização. A aplicação permite registrar, consultar, atualizar e excluir funcionários e departamentos, com um relacionamento de um para muitos (1:N) entre **Funcionário** e **Departamento**.

## Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para a construção da aplicação backend.
- **JPA (Java Persistence API)**: Usado para realizar o mapeamento objeto-relacional (ORM) entre a aplicação e o banco de dados.
- **H2 Database**: Banco de dados em memória utilizado para persistência durante o desenvolvimento (pode ser alterado para outros como MySQL ou PostgreSQL).
- **Swagger/OpenAPI**: Para documentação da API.
- **Jakarta Validation**: Para validação de dados de entrada.
- **Jackson**: Para serialização e desserialização de objetos Java em JSON.


## Funcionalidades

- **Cadastro de Funcionários**: Permite cadastrar funcionários com dados como nome, CPF, cargo, salário, etc.
- **Cadastro de Departamentos**: Permite cadastrar departamentos com dados como nome, descrição e funcionário responsável.
- **Listagem de Funcionários e Departamentos**: Exibe todos os funcionários ou departamentos cadastrados.
- **Consulta de Funcionários e Departamentos**: Permite consultar funcionários e departamentos por nome ou ID.
- **Deletação de Funcionários e Departamentos**: Permite remover funcionários e departamentos da base de dados.


## Relacionamento entre Entidades

- **Funcionario**: Cada funcionário pode estar vinculado a múltiplos departamentos.
- **Departamento**: Cada departamento tem um único funcionário responsável.

### Exemplo de Relacionamento:

- Um funcionário pode ser responsável por diversos departamentos, mas cada departamento será atribuído a um único funcionário.

## Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven (para gerenciamento de dependências)
- IDE de sua escolha (IntelliJ, Eclipse, VS Code, etc.)

### Passos para execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/cadastro-funcionario.git
   cd cadastro-funcionario
