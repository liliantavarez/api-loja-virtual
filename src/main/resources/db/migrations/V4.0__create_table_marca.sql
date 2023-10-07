create table marca
(
    id               bigint       not null auto_increment primary key,
    nome             varchar(250) not null,
    data_criacao     datetime,
    data_atualizacao datetime
)