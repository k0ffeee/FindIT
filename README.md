# FindIT

Uma API para obter informações sobre turismo 


### Endpoints 

- Agencia
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Pacotes 
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Destino 
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Viagem 
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Usuario
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Preferencias
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Caracteisticas 
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Passeio
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar


### Cadastrar Agencia 

`POST`/api/agencia

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|ID|Numeric|sim|ID da agencia para identifica-la
|Nome|text|sim|Nome do evento para poder indentificar.
|Sigla|text|não|Sigla do evento para poder indentificar.


**Exemplo de corpo de requisição**

```js
{
  "ID": 1,
  "Nome":"CVC",
  "Sigla": "CVC" 
}   

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Listar todos 

**Exemplo de corpo de requisição** 

```js
{
    "ID": 1,
    "Nome":"CVC",
    "Sigla": "CVC" 
}
{
    "ID": 1,
    "Nome":"123milhas",
    "Sigla": "123" 
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe evento cadastrado



