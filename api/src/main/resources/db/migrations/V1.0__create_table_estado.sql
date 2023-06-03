create table estado
(
    id               bigint      not null auto_increment primary key,
    nome             varchar(25) not null,
    sigla            varchar(2)  not null,
    data_criacao     datetime,
    data_atualizacao datetime
)