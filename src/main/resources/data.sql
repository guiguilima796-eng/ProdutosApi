create table produto (
    id varchar(255) primary key,
    nome varchar(50) not null,
    descricao varchar(255),
    preco decimal(10, 2) not null,
    quantidade numeric(10, 2) not null
);