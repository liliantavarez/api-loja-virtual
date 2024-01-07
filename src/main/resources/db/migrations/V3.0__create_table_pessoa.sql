create table pessoa
(
    id                       bigint       not null auto_increment primary key,
    nome                     varchar(250) not null,
    cpf                      varchar(14)  not null,
    email                    varchar(120) not null,
    senha                    varchar(120) not null,
    endereco                 varchar(250) not null,
    cep                      varchar(9)   not null,
    codigo_recuperacao_senha varchar(255),
    data_envio_codigo        datetime,
    cidade_id                bigint,
    data_criacao             datetime,
    data_atualizacao         datetime
)