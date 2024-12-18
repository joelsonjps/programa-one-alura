# Literalura: Catálogo de Livros e Autores

Este projeto é uma aplicação Java utilizando Spring Boot e PostgreSQL para gerenciar um catálogo de livros e autores. A aplicação permite buscar livros na API do Gutendex, salvar os dados em um banco de dados, e realizar diversas consultas e estatísticas sobre os livros e autores.

## Funcionalidades Principais

- **Buscar Livro por Título:** Consulta um livro pelo título na API do Gutendex e salva no banco de dados.
- **Listar Todos os Livros:** Exibe todos os livros salvos no banco de dados.
- **Listar Livros por Idioma:** Filtra livros por idioma.
- **Listar Autores Vivos em Determinado Ano:** Exibe autores que estavam vivos em um ano específico.
- **Gerar Estatísticas:** Mostra estatísticas sobre livros em diferentes idiomas.
- **Top 10 Livros Mais Baixados:** Lista os 10 livros mais baixados.
- **Buscar Autor por Nome:** Procura autores pelo nome no banco de dados.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Jackson (para manipulação de JSON)

## Como Executar

1. Clone o repositório.
2. Configure o banco de dados PostgreSQL.
3. Atualize o `application.properties` com suas credenciais do banco de dados.
4. Compile e execute a aplicação usando Maven:

   ```sh
   mvn clean install
   mvn spring-boot:run
