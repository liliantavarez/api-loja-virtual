insert into estado(nome, sigla, data_criacao)
values ('Pernambuco', 'PE', '2023-06-03T18:11:18.151+00:00');
insert into estado(nome, sigla, data_criacao)
values ('Paraiba', 'PB', '2023-06-03T18:21:28.151+00:00');
insert into estado(nome, sigla, data_criacao)
values ('Ceara', 'CE', '2023-06-03T18:31:38.151+00:00');

insert into cidade(nome, estado_id, data_criacao)
values ('Tabira', 1, '2023-06-04T18:10:32.341+00:00');
insert into cidade(nome, estado_id, data_criacao)
values ('Patos', 2, '2023-06-04T18:17:54.123+00:00');
insert into cidade(nome, estado_id, data_criacao)
values ('Fortaleza', 3, '2023-06-04T18:13:18.532+00:00');

insert into pessoa(nome, cpf, email, senha, endereco, cep, cidade_id)
values ('Gabriela Caroline Silveira', '47902986470', 'gabriela_caroline@email.com', 'wOBlFHynws',
        'Rua Manoel Pereira do Nascimento 1476', '56780970', 1);
insert into pessoa(nome, cpf, email, senha, endereco, cep, cidade_id)
values ('Fernando Vicente Jorge Campos', '93188684487', 'fernando-campos@email.com', 'pT9cClNf8u',
        'Rua Cirilo Garapa 167', '58705506', 2);
insert into pessoa(nome, cpf, email, senha, endereco, cep, cidade_id)
values ('Vera Adriana Vieira', '55101662313', 'vera-vieira84@email.com', '6xd96irsHK', 'Rua Betel 808', '60741148', 3);

insert into marca(nome, data_criacao)
values ('DELL', '2023-06-04T18:10:32.341+00:00');
insert into marca(nome, data_criacao)
values ('Sony', '2023-06-04T18:10:32.341+00:00');
insert into marca(nome, data_criacao)
values ('Samsung', '2023-06-04T18:10:32.341+00:00');
