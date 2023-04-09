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
  "id_agencia": 1,
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
`GET`/api/agencia
**Exemplo de corpo de requisição** 

```js
{
    "id_agencia": 1,
    "Nome":"CVC",
    "Sigla": "CVC" 
}
{
    "id_agencia": 2,
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
    "id_agencia": 1,
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


### Atualizar Pacotes

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


###  Listar todos pacotes 
`GET`/api/pacote
**Exemplo de corpo de requisição** 

```js
{
    "id_pacote": 1,
    "Nome":"Rio de janeiro",
    "Tipo": "Viagem de avião",
    "Descrição": "Viagem de avião com tudo pago para o rio de janeiro" 
}
{    
    "id_pacote": 2,
    "Nome":"Rio de janeiro",
    "Tipo": "Viagem de avião",
    "Descrição": "Viagem de avião com tudo pago para o rio de janeiro"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe pacote cadastrado


### Detalhar pacote 
`GET`/api/pacote/{id}
```js 
{
    "id_pacote": 1,
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



### Cadastrar Destino 
`POST`/api/destino

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Nome|text|sim|Nome do destino para poder indentificar.
|Descrição de ponto turistico|text|sim|Descrição do ponto turistico 
|Sigla do País|text|sim|Sigla do país de destino

**Exemplo de corpo de requisição**

```js
{
    "nome": "Cristo redentor",
    "ds_pontos_turisticos": "Cristo redentor que fica localizado no Rio de Janeiro",
    "sg_pais":  "BR" 
}   

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Atualizar destino
`PUT`/api/destino/{id}

**Exemplo de corpo de requisição**

```js
{
    "nome": "Grand Canyon",
    "ds_pontos_turisticos": "Grand Cannyon onde é localizado no arizona",
    "sg_pais":  "EUA" 
}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos



### Listar todos destinos

`GET`/api/destino


**Exemplo de corpo de requisição** 

```js
{
    "id_destino": 1,
    "nome": "Cristo redentor",
    "ds_pontos_turisticos": "Cristo redentor que fica localizado no Rio de Janeiro",
    "sg_pais":  "BR" 
}
{
    "id_destino": 2,
    "nome": "Grand Canyon",
    "ds_pontos_turisticos": "Grand Cannyon onde é localizado no arizona",
    "sg_pais":  "EUA" 
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe destino cadastrado


### Detalhar destino 

`GET`/api/destino/{id}
```js 
{
    "id_destino": 1,
    "nome": "Cristo redentor",
    "ds_pontos_turisticos": "Cristo redentor que fica localizado no Rio de Janeiro",
    "sg_pais":  "BR" 
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe destino cadastrada

### Apagar destino
`DELETE`/api/destino/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado




### Cadastrar viagem 

`POST`/api/viagem

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Descrição|text|sim|descrição da viagem para poder indentificar.
|Data da Partida|date|sim| Data da partida em que a viagem acontecerá. 
|Data da Volta|date|sim| Data da volta em que a viagem acontecerá.


**Exemplo de corpo de requisição**

```js
{
    "ds_viagem": "Viagem para o rio de janeiro",
    "dt_partida": "10/04/2023",
    "dt_fim": "20/04/2023"
}   

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos



### Atualizar viagem
`PUT`/api/viagem/{id}

**Exemplo de corpo de requisição**

```js
{    
    "ds_viagem": "Viagem para São Paulo",
    "dt_partida": "15/05/2023",
    "dt_fim": "20/05/2023"
}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos



### Listar todos 
`GET`/api/viagem
**Exemplo de corpo de requisição** 

```js
{
    "id_viagem": 1,
    "ds_viagem": "Viagem para o rio de janeiro",
    "dt_partida": "10/04/2023",
    "dt_fim": "20/04/2023"
}
{
    "id_viagem": 2,
    "ds_viagem": "Viagem para São Paulo",
    "dt_partida": "15/05/2023",
    "dt_fim": "20/05/2023"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe evento cadastrado


### Detalhar viagem 

`GET`/api/viagem/{id}
```js 
{
    "id_viagem": 2,
    "ds_viagem": "Viagem para São Paulo",
    "dt_partida": "15/05/2023",
    "dt_fim": "20/05/2023"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe viagem cadastrada

### Apagar viagem 
`DELETE`/api/viagem/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado

