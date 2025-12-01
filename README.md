# HeadlessCMS

Este projeto é um CMS Headless (Sistema de Gerenciamento de Conteúdo) construído com Java e PostgreSQL. Ele simula o backend de uma plataforma de Blog, modelando entidades complexas como Autores, Posts e Comentários, e é otimizado para a busca e a recuperação de metadados.

A ferramenta é capaz de gerenciar conteúdo de um Blog através de métodos de leitura, criação, atualização e exclusão, tudo isso através de comandos e parâmetros na URL.

### Sumário

1. [Status do Projeto](#1-status-do-projeto)
2. [Tecnologias Utilizadas](#2-tecnologias-utilizadas)
3. [Autor](#3-autor)

## 1. Status do Projeto

O projeto está em fase de construção da Lógica de Segurança e Persistência de Dados.

- [x] Estrutura Base (Pacotes): controller, service, repository, domain, configuration.
- [x] Modelagem de Domínio: Criação das entidades Author, Comment e Post.
- [x] Padrões Avançados JPA:
  - [x] Agregação/Relacionamentos (Post -> Author e Post -> Comment).
- [x] Camadas de Acesso a Dados (Repository): Definição das interfaces JpaRepository com métodos de busca personalizados.
- [x] Camada de Serviço (Service): Lógica de negócio e validações.
- [ ] Camada de Controle (Controller):
  - [x] Definição dos endpoints padrões (GET, POST, PUT e DELETE).
  - [ ] Programação do tratamento global de exceções.
- [ ] Segurança (JWT e Spring Security).
  - [ ] Configuração do PasswordEncoder.
  - [ ] Implementação da Autenticação via Token JWT.

## 2. Tecnologias Utilizadas

- Java 21
  - `Spring Boot 3.5.6`: Para agilizar o processo de criação (Framework).
  - `Spring Data JPA`: Para persistência de dados.
  - `PostgreSQL`: Para utilização de banco de dados.
  - `Spring Security e JWT`: Para aumentar a segurança.
  - `Maven`: Para o gerenciamento do projeto.

## 3. Autor

### Victor Freitas Matos

- LinkedIn: http://www.linkedin.com/in/victorfmatos
- GitHub: https://github.com/victorfmatos
