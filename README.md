<div align="center">
  
# Loja Virtual 

Desenvolvimento de uma loja virtual utilizando o spring, react e next.js

## Diagrama de Classes 
  
![image](https://github.com/liliantavarez/loja-virtual/assets/51184806/a3b04964-c7bc-459d-8b73-f0a10872c3b0)
</div>

## Stack utilizada

**Front-end:** React, JavaScript, Next.JS

**Back-end:** Java, Spring Boot, Maven, JPA, ModelMapper

**Database:** MySQL, Flyway


## Documentação da API

#### Retorna todos os estados

```http
  GET /api/estado
```
![image](https://github.com/liliantavarez/loja-virtual/assets/51184806/ce147abd-9fab-4622-bffb-804d0c7c771b)


#### Cadastra um estado

```http
  POST /api/estado
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. O nome do estado que você quer cadastrar |
| `sigla`      | `string` | **Obrigatório**. A sigla do estado que você quer cadastrar |

#### Exclui estado da base de dados

```http
  DEL /api/estado/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `number` | **Obrigatório**. O id do estado que você quer excluir 

```http
  PATCH /api/estado/${id}
```

#### Atualiza informações de determinado estado

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `number` | **Obrigatório**. O id do estado que você quer atualizar 

#### Retorna todos as cidades

```http
  GET /api/cidade
```
![image](https://github.com/liliantavarez/loja-virtual/assets/51184806/39541874-38f2-44d9-b2cb-8be8514e17e0)

#### Cadastra uma cidade

```http
  POST /api/cidade
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. O nome da cidade que você quer cadastrar |
| `id`      | `long` | **Obrigatório**. O id do estado da cidade que você quer cadastrar |

#### Exclui estado da base de dados

```http
  DEL /api/cidade/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `number` | **Obrigatório**. O id da cidade que você quer excluir 

```http
  PATCH /api/cidade/${id}
```

#### Atualiza informações de determinado estado

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `number` | **Obrigatório**. O id da cidade que você quer atualizar 

#### Retorna todos as pessoas

```http
  GET /api/pessoa
```
![localhost_8080_api_pessoa(Desktop) (2)](https://github.com/liliantavarez/loja-virtual/assets/51184806/c5575b7a-e787-47c3-b595-98db1b5fc62c)

#### Cadastra uma pessoa

```http
  POST /api/pessoa
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. O nome da pessoa que você quer cadastrar |
| `cpf`      | `string` | **Obrigatório**. O cpf da pessoa que você quer cadastrar |
| `email`      | `string` | **Obrigatório**. O email da pessoa que você quer cadastrar |
| `senha`      | `string` | **Obrigatório**. A senha da pessoa que você quer cadastrar |
| `endereco`      | `string` | **Obrigatório**. O endereco da pessoa que você quer cadastrar |
| `cep`      | `string` | **Obrigatório**. O cep da pessoa que você quer cadastrar |
| `id`      | `long` | **Obrigatório**. O id da cidade da pessoa que você quer cadastrar |

#### Exclui pessoa da base de dados

```http
  DEL /api/pessoa/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `number` | **Obrigatório**. O id da pessoa que você quer excluir 

```http
  PATCH /api/pessoa/${id}
```

#### Atualiza informações de determinado pessoa

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `number` | **Obrigatório**. O id da pessoa que você quer atualizar 

## Autores

- [@liliantavarez](https://www.linkedin.com/in/liliantavarez/)

