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
  "nm_agencia":"CVC",
  "sg_agencia": "CVC" 
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
  "nm_agencia":"CVC",
  "sg_agencia": "CVC" 
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
    "nm_agencia":"CVC",
    "sg_agencia": "CVC" 
}
{
    "id_agencia": 2,
    "nm_agencia":"123milhas"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe agencia cadastrado


### Detalhar Agencia 

`GET`/api/agencia/{id}
```js 
{
    "id_agencia": 1,
    "nm_agencia":"CVC",
    "sg_agencia": "CVC" 
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe agencia cadastrada

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
  "nm_pacote":"Rio de janeiro",
  "tp_pacote": "Viagem de avião",
  "ds_pacote": "Viagem de avião com tudo pago para o rio de janeiro"
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
  "nm_pacote":"Rio de janeiro",
  "tp_pacote": "Viagem de avião",
  "ds_pacote": "Viagem de avião com tudo pago para o rio de janeiro"
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
    "nm_pacote":"Rio de janeiro",
    "tp_pacote": "Viagem de avião",
    "ds_pacote": "Viagem de avião com tudo pago para o rio de janeiro" 
}
{    
    "id_pacote": 2,
    "nm_pacote":"Rio de janeiro",
    "tp_pacote": "Viagem de avião",
    "ds_pacote": "Viagem de avião com tudo pago para o rio de janeiro"
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
    "nm_pacote":"Rio de janeiro",
    "tp_pacote": "Viagem de avião",
    "ds_pacote": "Viagem de avião com tudo pago para o rio de janeiro" 
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe pacote cadastrada

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
    "nm_destino": "Rio de Janeiro",
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
    "nm_destino": "Arizona",
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
    "nm_destino": "Rio de janeiro",
    "ds_pontos_turisticos": "Cristo redentor que fica localizado no Rio de Janeiro",
    "sg_pais":  "BR" 
}
{
    "id_destino": 2,
    "nm_destino": "Arizona",
    "ds_pontos_turisticos": "Grand Cannyon onde é localizado no arizona",
    "sg_pais":  "EUA" 
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |404 | não existe destino cadastrado


### Detalhar destino 

`GET`/api/destino/{id}
```js 
{
    "id_destino": 1,
    "nm_destino": "Cristo redentor",
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
    |404 | não existe viagem cadastrado


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




### Cadastrar usuario 

`POST`/api/usuario

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Nome|text|sim|Nome do usuario para poder indentificar.
|Email|text|sim|Email do usuario.
|Senha|text|sim|Senha do usuario.



**Exemplo de corpo de requisição**

```js
{
  "nm_usuario":"FernandoCesxr",
  "nm_email": "rm95628@fiap.com.br",
  "nm_senha": "I0x3R9#5RGGF"
}

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Atualizar usuario
`PUT`/api/usuario/{id}

**Exemplo de corpo de requisição**

```js
{
  "nm_usuario":"Fernando",
  "nm_email": "cesarfernandocarlos@gmail.com",
  "nm_senha": "I0x3R9#5R"
}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Listar todos 
`GET`/api/usuario
**Exemplo de corpo de requisição** 

```js
{
    "id_usuario": 1,
    "nm_usuario":"FernandoCesxr",
    "nm_email": "rm95628@fiap.com.br",
    "nm_senha": "I0x3R9#5RGGF"
}
{
    "id_usuario": 2,
    "nm_usuario":"Fernando",
    "nm_email": "cesarfernandocarlos@gmail.com",
    "nm_senha": "I0x3R9#5R"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |404 | não existe usuario cadastrado

### Detalhar usuario 

`GET`/api/usuario/{id}
```js 
{
    "id_usuario": 1,
    "nm_usuario":"FernandoCesxr",
    "nm_email": "rm95628@fiap.com.br",
    "nm_senha": "I0x3R9#5RGGF"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe usuario cadastrada

### Apagar usuario
`DELETE`/api/usuario/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado


### Cadastrar preferencias 

`POST`/api/preferencias

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Nome|text|sim|sim|Nome da preferencia.
|Tipo|text|sim|sim|Tipo da preferencia.
|Descriação|text|sim|Descriação da preferencia. 


**Exemplo de corpo de requisição**

```js
{
  "nm_preferencia":"Clima",
  "tp_preferencia": "Calor" ,
  "ds_preferencia": "O usuário prefere calor"
}   

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Atualizar preferencias
`PUT`/api/preferencias/{id}

**Exemplo de corpo de requisição**

```js
{
  "nm_preferencia":"Clima",
  "tp_preferencia": "Frio" ,
  "ds_preferencia": "O usuário prefere frio"
}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos

### Listar todos 
`GET`/api/preferencia
**Exemplo de corpo de requisição** 

```js
{
    "id_preferencia": 1,
    "nm_preferencia":"Clima",
     "tp_preferencia": "Calor" ,
    "ds_preferencia": "O usuário prefere calor"
}
{
    "id_preferencia": 2,
     "nm_preferencia":"Clima",
     "tp_preferencia": "Frio" ,
     "ds_preferencia": "O usuário prefere frio"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe preferencia cadastrado


### Detalhar preferencia 

`GET`/api/preferencia/{id}
```js 
{
    "id_preferencia": 1,
    "nm_preferencia":"Clima",
    "tp_preferencia": "Calor" ,
    "ds_preferencia": "O usuário prefere calor"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404| não existe preferencia cadastrada


### Apagar preferencia
`DELETE`/api/preferencia/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado


### Cadastrar caracterista 

`POST`/api/caracterista

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Nome|text|sim|Nome da caracteristica para poder indentificar.
|Tipo|text|sim|Tipo da caracteristica para poder indentificar.
|Descrição|text|sim|Descrição da caracteristica.


**Exemplo de corpo de requisição**

```js
{
    "nm_caracteristica": "Clima",
    "tp_caracteristica": "Calor",
    "ds_caracteristica": "O lugar de destino é quente"
}   

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Atualizar caracterista
`PUT`/api/caracterista/{id}

**Exemplo de corpo de requisição**

```js
{    
    "id_caracterista": 1,
    "nm_caracteristica": "Clima",
    "tp_caracteristica": "Frio",
    "ds_caracteristica": "O lugar do destino é frio"

}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos


### Listar todos 
`GET`/api/caracteristica
**Exemplo de corpo de requisição** 

```js
{
    "id_caracterista": 1,
    "nm_caracteristica": "Clima",
    "tp_caracteristica": "Calor",
    "ds_caracteristica": "O lugar de destino é quente"
}
{
    "id_caracterista": 2,
    "nm_caracteristica": "Clima",
    "tp_caracteristica": "Frio",
    "ds_caracteristica": "O lugar do destino é frio"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |402 | não existe caracteristica cadastrado


### Detalhar caracterista 

`GET`/api/caracterista/{id}
```js 
{
    "id_caracterista": 1,
    "nm_caracteristica": "Clima",
    "tp_caracteristica": "Calor",
    "ds_caracteristica": "O lugar de destino é quente"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404| não existe caracterista cadastrada


### Apagar caracterista
`DELETE`/api/caracterista/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado




### Cadastrar passeio 

`POST`/api/passeio

|Campo|Tipo|Obrigatório|Descriação
|------ |------|:-----------: |---------
|Nome|text|sim|Nome do passeio para poder indentificar.
|Tipo|text|sim|Tipo do passeio para poder indentificar.
|Descrição|text|sim|Descrição da caracteristica.

**Exemplo de corpo de requisição**

```js
{
    "nm_passeio": "Cristo redentor",
    "tp_passeio": "Pontos turisticos",
    "ds_passeio": "Passeio para o cristo redentor"
}   

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos



### Atualizar passeio
`PUT`/api/passeio/{id}

**Exemplo de corpo de requisição**

```js
{
    "nm_passeio": "MASP",
    "tp_passeio": "Pontos turisticos",
    "ds_passeio": "Passeio para o MASP"
}   

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|400 | os campos enviados sao invalidos

### Listar todos 
`GET`/api/passeio
**Exemplo de corpo de requisição** 

```js
{
    "id_passeio": 1,
    "nm_passeio": "Cristo redentor",
    "tp_passeio": "Pontos turisticos",
    "ds_passeio": "Passeio para o cristo redentor"
}
{
    "id_passeio": 2,
    "nm_passeio": "MASP",
    "tp_passeio": "Pontos turisticos",
    "ds_passeio": "Passeio para o MASP"
}
```

**Cógigos de respota**

    |código| descrição
    | - | -
    |200 | dados retornados com sucesso
    |404| não existe passeio cadastrado


### Detalhar passeio 

`GET`/api/passeio/{id}
```js 
{
    "id_passeio": 1,
    "nm_passeio": "Cristo redentor",
    "tp_passeio": "Pontos turisticos",
    "ds_passeio": "Passeio para o cristo redentor"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|402 | não existe passeio cadastrada


### Apagar passeio
`DELETE`/api/passeio/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado


