# Users API

## Sumário

- [Descrição](#descrição)
- [Requisitos](#requisitos)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Documentação da API](#documentação-da-api)
- [Licença](#licença)

---

## Descrição

Este é um microserviço desenvolvido em **Spring Boot** que tem como objetivo fornecer uma API para realizar CRUD (Create, Read, Update, Delete) de usuários. O projeto utiliza o banco de dados PostgreSQL para persistência dos dados.

O serviço é configurado para rodar em um ambiente baseado em **Java 17** e não utiliza Spring Security.

---

## Requisitos

- Java 17
- Docker (Opcional)
- PostgreSQL instalado e rodando na máquina/local

---

## Funcionalidades

- **CRUD de Usuários**:
    - **Create**: Endpoint para criação de novos usuários.
    - **Read**: Endpoint para consulta de todos os usuários ou usuário específico.
    - **Update**: Endpoint para atualização de informações de um usuário.
    - **Delete**: Endpoint para remoção de um usuário.

- **Swagger**: Documentação da API acessível em `http://localhost:8080/swagger-ui/index.html` para teste e consulta dos endpoints.

---

#
