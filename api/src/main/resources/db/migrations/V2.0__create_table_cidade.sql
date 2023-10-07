create table cidade
(
    id               bigint      not null auto_increment primary key,
    nome             varchar(35) not null,
    estado_id        bigint,
    data_criacao     datetime,
    data_atualizacao datetime
)