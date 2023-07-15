create table produto
(
    id                 bigint       not null auto_increment primary key,
    nome               varchar(150) not null,
    descricaoCurta     varchar(255) not null,
    descricaoDetalhada text         not null,
    valorCusto         double       not null,
    valorVenda         double       not null,
    marca_id           bigint,
    categoria_id       bigint,
    data_criacao       datetime,
    data_atualizacao   datetime
)