# TesteFinalJavaMinsait
Este projeto é uma API REST desenvolvida para fins de estudo, que permite a gestão de empréstimos de uma empresa financeira.

Funcionalidades
A API REST deste projeto suporta as seguintes operações:

POST: cadastra um cliente (a formatação nos atributos cpf, telefone e cep é obrigatória).
GET: retorna todos os clientes cadastrados.
GET: retorna um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado).
DELETE: deleta um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado).
PUT: altera um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado e a formatação nos atributos cpf, telefone e cep é obrigatória).
POST: cadastra um empréstimo para um cliente (o CPF deve ser de um cliente já cadastrado e o atributo relacionamento só permite valores de "Ouro", "Prata" e "Bronze").
DELETE: deleta um empréstimo pelo CPF e ID (o CPF deve ser de um cliente já cadastrado e o ID deve ser de um empréstimo relacionado ao cliente).
GET: retorna todos os empréstimos de um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado).
GET: retorna um empréstimo específico de um cliente pelo CPF e ID (o CPF deve ser de um cliente já cadastrado e o ID deve ser de um empréstimo relacionado ao cliente).
