# Loja Virtual 

Desenvolvimento de uma loja virtual utilizando o spring, react e next.js


## Stack utilizada

**Front-end:** React, JavaScript, Next.JS

**Back-end:** Java, Spring Boot, Maven, JPA, ModelMapper

**Database:** MySQL, Flyway


## Documentação da API

#### Retorna todos os estados

```http
  GET /api/estado
```

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

## Autores

- [@liliantavarez](https://www.linkedin.com/in/liliantavarez/)

