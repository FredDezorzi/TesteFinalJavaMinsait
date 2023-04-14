# TesteFinalJavaMinsait
Este projeto é uma API REST desenvolvida para fins de estudo, que permite a gestão de empréstimos de uma empresa financeira.

## Funcionalidades
A API REST deste projeto suporta as seguintes operações:

- POST: cadastra um cliente (a formatação nos atributos cpf, telefone e cep é obrigatória).
- GET: retorna todos os clientes cadastrados.
- GET: retorna um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado).
- DELETE: deleta um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado).
- PUT: altera um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado e a formatação nos atributos cpf, telefone e cep é obrigatória).
- POST: cadastra um empréstimo para um cliente (o CPF deve ser de um cliente já cadastrado e o atributo relacionamento só permite valores de "Ouro", "Prata" e "Bronze").
- DELETE: deleta um empréstimo pelo CPF e ID (o CPF deve ser de um cliente já cadastrado e o ID deve ser de um empréstimo relacionado ao cliente).
- GET: retorna todos os empréstimos de um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado).
- GET: retorna um empréstimo específico de um cliente pelo CPF e ID (o CPF deve ser de um cliente já cadastrado e o ID deve ser de um empréstimo relacionado ao cliente).

## Tecnologias utilizadas
Este projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java
- Maven
- Spring Boot

## Pré-requisitos
Para executar este projeto, é necessário ter instalado:

- JDK
- Maven

## Como usar
Este projeto pode ser utilizado através de chamadas HTTPS. A seguir, estão listadas as instruções para cada uma das chamadas suportadas pela API, juntamente com uma descrição do que cada uma delas faz:

- POST: cadastra um cliente (a formatação nos atributos cpf, telefone e cep é obrigatória): " http://localhost:8080/api/v1/empresa/clientes "

Exemplo de JSON:
```json  

{
	"nome": "Frederico Dezorzi",
	"cpf": "111.222.333-45",
	"telefone": "(99)99999-9999",
	"rua": "Rua Pedro de Godoi",
	"numero":"269",
	"cep": "03138-010",
	"rendimentoMensal":"50000"
}

```
- GET: retorna todos os clientes cadastrados: "http://localhost:8080/api/v1/empresa/clientes"

- GET: retorna um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado): "http://localhost:8080/api/v1/empresa/clientes/:cpf"

- DELETE: deleta um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado): "http://localhost:8080/api/v1/empresa/clientes/:cpf"

- PUT: altera um cliente pelo CPF (o CPF deve ser de um cliente já cadastrado e a formatação nos atributos cpf, telefone e cep é obrigatória): "http://localhost:8080/api/v1/empresa/clientes/:cpf"

Exemplo de JSON:
```json  

{
	"nome": "Anderson Dezorzi",
	"telefone": "(88)8888-8888",
	"rua": "Rua Pedro de Godoi",
	"numero":"269",
	"cep": "03138-010",
	"rendimentoMensal":"50000"
}

```
- POST Cadastra um emprestimo para um cliente (Obrigatorio passar um CPF de um cliente já cadastrado como parametro e atributo relacionamento só permite valor de "Ouro", "Prata" e "Bronze"): "http://localhost:8080/api/v1/empresa/clientes/:cliente/emprestimos"

Exemplo de JSON:
```json  

{
	"valorInicial": "10",
	"relacionamento": "Ouro",
	"dataInicial": "2022-01-23",
	"dataFinal":"2022-02-15"
}

```
- DELETE Deleta um emprestimo pelo CPF e ID (Obrigatorio passar um CPF de um cliente já cadastrado e um Id de algum emprestimo relacionado ao cliete como parametros): "http://localhost:8080/api/v1/empresa/clientes/:cpf/emprestimos/:id"

- GET Retorna todos os emprestimos de um cliente pelo CPF (Obrigatorio passar um CPF de um cliente já cadastrado como parametro): "http://localhost:8080/api/v1/empresa/clientes/:cpf/emprestimos"
	
- GET Retorna um emprestimo especifico para um cliente pelo CPF e ID (Obrigatorio passar um CPF de um cliente já cadastrado e um Id de algum emprestimo relacionado ao cliete como parametros):"http://localhost:8080/api/v1/empresa/clientes/:cpf/emprestimos/:id"

## Autor
Este projeto foi desenvolvido por Frederico Costa do Nascimento Dezorzi. Entre em contato por meio dos seguintes meios:

- E-mail: fred.dezorzi@gmail.com
- Telefone: (11) 97286-1327
- LinkedIn: https://www.linkedin.com/in/frederico-costa-do-nascimento-dezorzi-529518182
- GitHub: https://github.com/Fred

## Agradecimentos
Agradeço a Minsait por disponibilizar o teste e permitir o desenvolvimento deste projeto.



