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
|Nome|text|sim|Nome da agencia para poder indentificar.
|Sigla|text|não|Sigla da agencia para poder indentificar.


**Exemplo de corpo de requisição**

```js
{
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


### Atualizar agencia
`PUT`/api/agencia/{id}

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
    "ID": 2,
    "Nome":"123milhas",
    "Sigla": "" 
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe agencia cadastrado


### Detalhar Agencia 

`GET`/api/agencia/{id}
```js 
{
    "ID": 1,
    "Nome":"CVC",
    "Sigla": "CVC" 
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe agencia cadastrada

### Apagar agencia
`DELETE`/api/agencia/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado


### Cadastrar Pacote

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Nome|text|sim|Nome do pacote para poder indentificar.
|Tipo|text|sim|Tipo do pacote.
|Descrição|text|sim|Descriçao do pacote.

**Exemplo de corpo de requisição**

```js
{
  "Nome":"Rio de janeiro",
  "Tipo": "Viagem de avião",
  "Descrição": "Viagem de avião com tudo pago para o rio de janeiro"
}   

```
**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


## Atualizar Pacotes

`PUT`/api/pacote/{id}

**Exemplo de corpo de requisição**

```js
{
  "Nome":"Rio de janeiro",
  "Tipo": "Viagem de avião",
  "Descrição": "Viagem de avião com tudo pago para o rio de janeiro"
}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


##  Listar todos pacotes 

**Exemplo de corpo de requisição** 

```js
{
    "ID": 1,
    "Nome":"Rio de janeiro",
    "Tipo": "Viagem de avião",
    "Descrição": "Viagem de avião com tudo pago para o rio de janeiro" 
}
{    
    "ID": 2,
    "Nome":"Rio de janeiro",
    "Tipo": "Viagem de avião",
    "Descrição": "Viagem de avião com tudo pago para o rio de janeiro"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe evento cadastrado


### Detalhar pacote 

`GET`/api/pacote/{id}
```js 
{
    "ID": 1,
    "Nome":"Rio de janeiro",
    "Tipo": "Viagem de avião",
    "Descrição": "Viagem de avião com tudo pago para o rio de janeiro" 
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe pacote cadastrada

### Apagar pacote
`DELETE`/api/pacote/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado




