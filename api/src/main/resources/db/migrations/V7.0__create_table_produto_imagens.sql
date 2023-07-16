create table produto_imagens
(
    id               bigint       not null auto_increment primary key,
    nome             varchar(150) not null,
    produto_id       bigint,
    data_criacao     datetime,
    data_atualizacao datetime
)